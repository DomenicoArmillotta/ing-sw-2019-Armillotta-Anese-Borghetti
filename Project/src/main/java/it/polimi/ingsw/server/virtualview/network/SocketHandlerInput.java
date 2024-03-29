package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.mvevents.eventbeans.ConnectionInterruptEventBean;
import it.polimi.ingsw.server.virtualview.serverevents.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.Socket;

/**
 * manage all input of a single client towards the server and parse the input creating a ServerEvent
 */

public class SocketHandlerInput implements Runnable {
    private Socket socket;
    private Controller  controller;
    private EventsBuffer eventsBuffer;

    /**
     * create a new SocketHandlerOutput
     * @param socket client socket
     * @param controller server controller
     */
    public SocketHandlerInput(Socket socket, Controller controller) {
        this.socket = socket;
        this.controller = controller;
        this.eventsBuffer = EventsBuffer.instance();
        eventsBuffer.flushBuffer();
    }

    /**
     * keeps reading from the input until bufferedReader read a connection Interrupt or end of stream.
     * when a client disconnects anomalously or decidec to quit the game the socketHandlerInput signals to the game is going to be ended
     * and start the procedure for rebooting @see socketHandlerOutpu
     */
    public void run() {
        BufferedReader brd = null;
        synchronized (eventsBuffer.brdLock) {
            try {
                brd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.out.println("errore a creare lo stream di input");
                e.printStackTrace();
            }
        }

        controller.addScannerInToList(new LineClientSocketsAndPort(socket,socket.getPort()));

        try{
            String userInput = "";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            System.out.println(userInput);
            //tolto dal while le righe qui sopra.

            while((userInput = brd.readLine()) != null){
                System.out.println("Ready to read");
                StringReader sr = new StringReader(userInput);
                InputSource is = new InputSource(sr);
                Document document = null;
                try {
                    document = db.parse(is);
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ServerEvent serverEvent = returnCorrectServerEvent(document);
                System.out.println(serverEvent);
                serverEvent.serverEventMethod(controller);
                System.out.println("Done");
            }
            /*/
            solo quando il client crasha in game oppure viene chiuso o non è ancora partito;
             */

        } catch (IOException | ParserConfigurationException t) {
            System.out.println("exceptional disconnection");
            System.err.println(t.getMessage());
        } finally {
            if(!EventsBuffer.instance().getEndGame()) {
                eventsBuffer.setLastEventBean(new ConnectionInterruptEventBean("payload"));
                controller.deleteElementInScannerInList(Integer.toString(socket.getPort()));
                eventsBuffer.setEndGame();
                while (EventsBuffer.instance().isSendEventBeanLock())
                    ;
                System.out.println("chiusura inaspettata");
            }else
                controller.deleteElementInScannerInList(Integer.toString(socket.getPort()));
            try {
                brd.close();//sia socket che input stream;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * create a ServerEvent from the input that the server received form a client by using the doc document passed by the SocketHandlerInput.
     *
     * @param doc document containing the xml version of the original String Message
     * @return ServerEvent or null if there are no such event in the server.
     */
    protected ServerEvent returnCorrectServerEvent(Document doc){
        if(doc.getDocumentElement().getTagName().equals("GameCoordsEvent")) {
            int x,y;
            x = Integer.parseInt(doc.getElementsByTagName("x").item(0).getTextContent());
            y = Integer.parseInt(doc.getElementsByTagName("y").item(0).getTextContent());
            return new it.polimi.ingsw.server.virtualview.serverevents.GameCoordsEvent(x,y);
        }

        if(doc.getDocumentElement().getTagName().equals("SetupCoordsEvent")) {
            int x,y,z,w;
            x = Integer.parseInt(doc.getElementsByTagName("x").item(0).getTextContent());
            y = Integer.parseInt(doc.getElementsByTagName("y").item(0).getTextContent());
            z = Integer.parseInt(doc.getElementsByTagName("z").item(0).getTextContent());
            w = Integer.parseInt(doc.getElementsByTagName("w").item(0).getTextContent());
            return new it.polimi.ingsw.server.virtualview.serverevents.SetupCoordsEvent(x,y,z,w);
        }

        if(doc.getDocumentElement().getTagName().equals("LoginEvent")){
            String payload = doc.getElementsByTagName("payload").item(0).getTextContent();
            return new LoginEvent(payload);
        }
        if(doc.getDocumentElement().getTagName().equals("StartUpEvent")){
            String playerComm = doc.getElementsByTagName("playerComm").item(0).getTextContent();
            String numberOfPlayers = doc.getElementsByTagName("numberOfPlayers").item(0).getTextContent();
            return new StartUpEvent(playerComm,numberOfPlayers);
        }
        if(doc.getDocumentElement().getTagName().equals("GodChoiceEvent")){
            String chosenGod = doc.getElementsByTagName("chosenGod").item(0).getTextContent();
            String player = doc.getElementsByTagName("player").item(0).getTextContent();
            return new GodChoiceEvent(chosenGod, player);
        }
        if(doc.getDocumentElement().getTagName().equals("BooleanEvent"))
            return new BooleanEvent(Boolean.parseBoolean(doc.getElementsByTagName("answer").item(0).getTextContent()));

        if(doc.getDocumentElement().getTagName().equals("GodListEvent")) {
            String god1 = doc.getElementsByTagName("god1").item(0).getTextContent();
            String god2 = doc.getElementsByTagName("god2").item(0).getTextContent();
            String god3 = doc.getElementsByTagName("god3").item(0).getTextContent();
            return new PartyOwnerGodListEvent(god1,god2,god3);
        }
        if(doc.getDocumentElement().getTagName().equals("ClientAckDisconnectionEvent")){
            String socket = doc.getElementsByTagName("socketToDisconnect").item(0).getTextContent();
            return new ClientDisconnectRequestEvent(socket);
        }
        return null;
    }
}
