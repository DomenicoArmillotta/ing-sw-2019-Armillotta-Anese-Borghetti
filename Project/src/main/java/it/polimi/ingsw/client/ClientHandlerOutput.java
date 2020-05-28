package it.polimi.ingsw.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

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

    private Socket socket;

    public ClientHandlerOutput(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        /* System.out.println("[ClientHandlerOutput] Connection established"); */
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* System.out.println("socket: " + socket); */
        ProxyModel proxyModel = ProxyModel.instance();
        //proxyModel.setGamePhase(GamePhase.LOGIN);
        Scanner stdin = new Scanner(System.in);

        try {
            System.out.println(ANSI_PURPLE+"SANTORINI BOARD GAME CLI SIMULATION"+ANSI_RESET+" (AM46)");
            System.out.println("Type "+ANSI_YELLOW+"login"+ANSI_RESET+" followed by your nickname to create a room or join an existing one.");
            while (true) {
                /* System.out.println("GAME PHASE: "+proxyModel.getPhase()); */
                String inputLine = stdin.next();
                if (inputLine.equals("quit")) {
                    //proxyModel.setGamePhase(GamePhase.DISCONNECTED);
                    break;
                } else {
                    if (inputLine.equals("login") && proxyModel.getThisClientNickname().equals("") && proxyModel.getPhase() == 0) {
                        if (stdin.hasNextLine()) {
                                inputLine = stdin.next();
                                proxyModel.setThisClientNickname(inputLine);
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new LoginEvent(proxyModel.getThisClientNickname()));
                                toSend += "\n";
                                printWriter.print(toSend);
                                /* System.out.print(toSend);
                                System.out.println(""); */
                                printWriter.flush();
                            System.out.println(ANSI_GREEN + "[Flushed login request (" + inputLine + ")]" + ANSI_RESET);
                            }
                    } else if (inputLine.equals("bool") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname())  && proxyModel.getPhase() == 3) {
                        if (stdin.hasNextBoolean()) {
                            Boolean answer = stdin.nextBoolean();
                            XmlMapper xmlMapper = (new XmlMapper());
                            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                            String toSend = xmlMapper.writeValueAsString(new BooleanEvent(answer));
                            toSend += "\n";
                            printWriter.print(toSend);
                            /* System.out.print(toSend);
                            System.out.println(""); */
                            printWriter.flush();
                            System.out.println(ANSI_GREEN + "[Flushed bool answer (" + answer + ")]" + ANSI_RESET);
                        }
                    }else if (inputLine.equals("start") && proxyModel.getThisClientNickname().equals(proxyModel.getPartyOwner()) && proxyModel.getPlayers().size() > 1 && proxyModel.getPhase() == 0) { /* playerComm */
                        if (stdin.hasNextInt()) {
                            int num = stdin.nextInt();
                            if(num <= proxyModel.getPlayers().size()) {
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new StartUpEvent(proxyModel.getThisClientNickname()));
                                toSend += "\n";
                                printWriter.print(toSend);
                            /* System.out.print(toSend);
                            System.out.println(""); */
                                printWriter.flush();
                                System.out.println(ANSI_GREEN + "[Flushed start request (" + proxyModel.getPlayers().size() + " players)]" + ANSI_RESET);
                            } else {
                                System.out.println(ANSI_RED+"[There are only "+proxyModel.getPlayers().size()+" players in the room]"+ANSI_RESET);
                            }
                        }
                    } else if (inputLine.equals("coords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname()) && proxyModel.getPhase() == 3) {
                        if (stdin.hasNextInt()) {
                            int x = stdin.nextInt();
                            if (stdin.hasNextInt()) {
                                int y = stdin.nextInt();
                                /* System.out.println("Read coords " + x + " " + y); */
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new GameCoordsEvent(x, y));
                                toSend += "\n";
                                printWriter.print(toSend);
                                /* System.out.print(toSend);
                                System.out.println(""); */
                                printWriter.flush();
                                System.out.println(ANSI_GREEN + "[Flushed coords (" + x + ", "+ y +")]" + ANSI_RESET);
                                /* System.out.println("Flushed coords " + x + " " + y); */
                            }
                        }
                    } else if (inputLine.equals("god") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname()) && proxyModel.getTurn().getPlayerByName(proxyModel.getThisClientNickname()).getGodCard() == null && proxyModel.getPhase() == 1) {
                        String stringInput = stdin.next();
                        /* System.out.println("Read GodChoice " + stringInput); */
                        XmlMapper xmlMapper = (new XmlMapper());
                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                        String toSend = xmlMapper.writeValueAsString(new GodChoiceEvent(stringInput, proxyModel.getThisClientNickname()));
                        toSend += "\n";
                        printWriter.print(toSend);
                        /* System.out.print(toSend);
                        System.out.println(""); */
                        printWriter.flush();
                        System.out.println(ANSI_GREEN + "[Flushed god choice (" + stringInput + ")]" + ANSI_RESET);
                    } else if (inputLine.equals("coords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname()) && proxyModel.getPhase() == 2) {
                        if (stdin.hasNextInt()) {
                            int x = stdin.nextInt();
                            if (stdin.hasNextInt()) {
                                int y = stdin.nextInt();
                                if (stdin.hasNextInt()) {
                                    int z = stdin.nextInt();
                                    if (stdin.hasNextInt()) {
                                        int w = stdin.nextInt();
                                        XmlMapper xmlMapper = (new XmlMapper());
                                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                        String toSend = xmlMapper.writeValueAsString(new SetupCoordsEvent(x, y, z, w));
                                        toSend += "\n";
                                        printWriter.print(toSend);
                                        /* System.out.print(toSend);
                                        System.out.println(""); */
                                        printWriter.flush();
                                        System.out.println(ANSI_GREEN + "[Flushed coords (" + x + ", "+ y +", "+ z +", "+ w +")]" + ANSI_RESET);
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println(ANSI_RED+"[Unknown/incorrect command \""+inputLine+"\"]"+ANSI_RESET);
                    }
                } }
            } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
    }
}
