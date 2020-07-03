package it.polimi.ingsw.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.proxymodel.Phase;
import it.polimi.ingsw.client.proxymodel.Player;
import it.polimi.ingsw.client.proxymodel.ProxyModel;
import it.polimi.ingsw.server.model.mvevents.eventbeans.GameStartEventBean;

import java.io.*;
import java.net.Socket;
import java.util.*;
/**
 * ClientHandlerInput it's used for send event to server
 */
public class ClientHandlerOutput implements Runnable {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    List<String> commands = Arrays.asList("login", "gods", "god", "coords", "start", "true", "false", "bool");
    List<Integer> caratteri = Arrays.asList(48,49,50,51,52,53,54,55,56,57,56);

    private Socket socket;

    public ClientHandlerOutput(Socket socket) {
        this.socket = socket;
    }

    /**
     *reads from user input and create the correct ClientEvent to send to the server, creates a string in xml formats and than flush.
     * if the parser return null as new ClientEvent that means that something was wrong with the input
     */
    public void run() {

        /* System.out.println("[ClientHandlerOutput] Connection established"); */
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        ProxyModel proxyModel = ProxyModel.instance();
        Scanner stdin = new Scanner(System.in);
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        Phase clientPhase = ProxyModel.instance().getPhase();
        XmlMapper xmlMapper = (new XmlMapper());
        String toSend = "";
        ClientEvent eventToSend = new ClientEvent();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        ProxyModel.instance().setPrintWriter(printWriter);
        System.out.println(ANSI_PURPLE + "SANTORINI BOARD GAME CLI SIMULATION" + ANSI_RESET + " (AM46)");
        System.out.println("Type " + ANSI_YELLOW + "login" + ANSI_RESET + " followed by your nickname to create a room or join an existing one.");
        String inputLine = null;

        while (true) {
            try{
                inputLine= brd.readLine();
            } catch (IOException | NullPointerException r) {
                System.out.println("error during reading of client input");
                r.printStackTrace();
            }

            //String inputLine = stdin.nextLine();

                List<String> userInput = spaceStripper(inputLine);
                if (commands.contains(userInput.get(0)) && userInput.size() > 1) {
                    eventToSend = createUserEventToSend(userInput, proxyModel);
                    if (eventToSend == null)
                        System.out.println("formato dell'ultima azione inserita non corretto,reinserire");
                    else {
                        try {
                            toSend = xmlMapper.writeValueAsString(eventToSend);
                            toSend += "\n";
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                        if (printWriter != null) {
                            printWriter.print(toSend);
                            printWriter.flush();
                        } else
                            System.out.println("errore con il printWriter");
                        /*reset lista per eveitare problemi sovrascrittura*/
                        userInput.clear();
                    }
                } else
                    System.out.println(ANSI_RED + "[Unknown/incorrect command \"" + inputLine + "\"]" + ANSI_RESET);
        }
    }

    /**
     * take the keyboard Input of a player and remove all whitespaces and add every atomic word into a list.
     * @param toSend list containing all words in user Input
     * @return List of strings that is the collection of all atomic word in the keyboard input
     */
    public List<String> spaceStripper(String toSend){
            List<String> parsedString = new ArrayList<>();
            for(String atomicWord: toSend.split("\\s+")){
                //atomicWord.replaceAll("\\s+","");
                if(!atomicWord.equals(""))
                    parsedString.add(atomicWord);
            }
            return parsedString;
        }

    /**
     * Take the list of strings that represent the keyboard input and create the correct ClientEvent.
     * if an element of the list is not compliance with a specific ClientEvent return null;
     *
     * @param userInput keyboard input of the client
     * @param proxyModel current proxymodel
     * @return null if there is no such event of the type contained in user input else the correct ClientEvent
     */
        public ClientEvent createUserEventToSend(List<String> userInput,ProxyModel proxyModel) {
            if (userInput.get(0).equals("login") && proxyModel.getPhase().ordinal() == Phase.LOGIN.ordinal()) {
                if (userInput.get(1).equals("")) {
                    System.out.println("nome non valido");
                    return null;
                }
                for (Player players : proxyModel.getPlayers())
                    if(players.getName().equals(userInput.get(1))){
                        System.out.println("nick name gia preso , reinserire un nickname valido");
                        return new LoginEvent(userInput.get(1));
                    }
                if(proxyModel.getThisClientNickname().equals("") && proxyModel.getPlayers().size()<3) {
                    /* System.out.println("numero attuale players: "+proxyModel.getPlayers().size()); */
                    proxyModel.setThisClientNickname(userInput.get(1));
                    return new LoginEvent(userInput.get(1));
                }
            }
            if (userInput.get(0).equals("bool") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname()) && proxyModel.getPhase().ordinal() == Phase.GAME.ordinal()) {
                if (userInput.get(1).equals("true") || userInput.get(1).equals("false"))
                    return new BooleanEvent(Boolean.parseBoolean(userInput.get(1)));
                else
                    return null;
            }
            if (userInput.get(0).equals("coords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname()) && proxyModel.getPhase().ordinal() == Phase.SETUP.ordinal()) {
                /**/
                userInput.remove(0);
                userInput = refactorCoordinatesInput(userInput);
                if(userInput.size()<4){
                    return null;
                }
                if(caratteri.contains((int)(userInput.get(0).charAt(0))) && caratteri.contains((int)(userInput.get(1).charAt(0))) && caratteri.contains((int)(userInput.get(2).charAt(0)))&& caratteri.contains((int)(userInput.get(3).charAt(0)))) {
                    int x = Integer.parseInt(userInput.get(0));
                    int y = Integer.parseInt(userInput.get(1));
                    int z = Integer.parseInt(userInput.get(2));
                    int g = Integer.parseInt(userInput.get(3));
                    return new SetupCoordsEvent(x, y, z, g);
                }
            }
            if (userInput.get(0).equals("coords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname()) && proxyModel.getPhase().ordinal() == Phase.GAME.ordinal()) {
                userInput.remove(0);
                userInput = refactorCoordinatesInput(userInput);
                /*
                controllo formato coordinate
                 */
                if(userInput.size()<2)
                    return null;

                if(caratteri.contains((int)(userInput.get(0).charAt(0))) && caratteri.contains((int)(userInput.get(1).charAt(0)))) {
                    int x = Integer.parseInt(userInput.get(0));
                    int y = Integer.parseInt(userInput.get(1));
                    return new GameCoordsEvent(x, y);
                }else
                    return null;
            }
            if (userInput.get(0).equals("start") && proxyModel.getThisClientNickname().equals(proxyModel.getPartyOwner()) && proxyModel.getPlayers().size() > 1 && proxyModel.getPhase().ordinal() == Phase.LOGIN.ordinal()) {
                if (proxyModel.getPlayers().size() == 2 || proxyModel.getPlayers().size() == 3)
                    return new StartUpEvent(proxyModel.getThisClientNickname(),userInput.get(1));
                else
                    return null;
            }
            if ((userInput.get(0).equals("god") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname()) && proxyModel.getTurn().getPlayerByName(proxyModel.getThisClientNickname()).getGodCard() == null && proxyModel.getPhase().ordinal() == Phase.PLAYER_GOD_CHOICE.ordinal())) {
                if(userInput.size()>1)
                    return new GodChoiceEvent(userInput.get(1), proxyModel.getThisClientNickname());
            }
            if (userInput.get(0).equals("gods") && proxyModel.getPartyOwner().equals(proxyModel.getThisClientNickname()) && proxyModel.getPhase().ordinal() == Phase.OWNER_GOD_CHOICE.ordinal()) {
                if (proxyModel.getPlayers().size() == 2 && userInput.size()>=3) {
                    return new GodListEvent(userInput.get(1).toLowerCase(),userInput.get(2).toLowerCase(),null);

                }else {
                    if (proxyModel.getPlayers().size() == 3 && userInput.size() >= 4)
                        return new GodListEvent(userInput.get(1).toLowerCase(), userInput.get(2).toLowerCase(), userInput.get(3).toLowerCase());
                }
                return null;
            }
            return  null;
        }

    /**
     * parse correctly the coordinates by returning only the first character of every word int he list of the input.
     * @param userInput coordinates input in List of strings format
     * @return list with only the first character of every word.
     */
    public List<String> refactorCoordinatesInput(List<String> userInput) {
        for (int i = 1; i != userInput.size(); i++) {
            String s = Character.toString(userInput.get(i).charAt(0));
            userInput.set(i, s);
        }
        return userInput;
    }
}