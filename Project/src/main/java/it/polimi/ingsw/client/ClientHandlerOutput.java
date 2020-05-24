package it.polimi.ingsw.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandlerOutput implements Runnable {

    private Socket socket;
    private GamePhase gamePhase;

    public ClientHandlerOutput(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        System.out.println("Connection established Ouput");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("socket: " + socket);
        ProxyModel proxyModel = ProxyModel.instance();
        Scanner stdin = new Scanner(System.in);

        try {

            while (true) {
                String inputLine = stdin.next();
                if (inputLine.equals("quit")) {
                    this.gamePhase = GamePhase.DISCONNECTED;
                    break;
                } else {
                    if (inputLine.equals("login") && proxyModel.getThisClientNickname().equals("")) {
                        if (stdin.hasNextLine()) {
                                inputLine = stdin.next();
                                proxyModel.setThisClientNickname(inputLine);
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new LoginEvent(proxyModel.getThisClientNickname()));
                                toSend += "\n";
                                printWriter.print(toSend);
                                System.out.print(toSend);
                                System.out.println("");
                                printWriter.flush();
                            }
                    } else if (inputLine.equals("start") && proxyModel.getThisClientNickname().equals(proxyModel.getPartyOwner())) { /* playerComm */
                        XmlMapper xmlMapper = (new XmlMapper());
                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                            String toSend = xmlMapper.writeValueAsString(new StartUpEvent(proxyModel.getThisClientNickname()));
                            toSend += "\n";
                            printWriter.print(toSend);
                            System.out.print(toSend);
                            System.out.println("");
                            printWriter.flush();
                    } else if (inputLine.equals("coords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname())) {
                        if (stdin.hasNextInt()) {
                            int x = stdin.nextInt();
                            if (stdin.hasNextInt()) {
                                int y = stdin.nextInt();
                                System.out.println("Read coords " + x + " " + y);
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new GameCoordsEvent(x, y));
                                toSend += "\n";
                                printWriter.print(toSend);
                                System.out.print(toSend);
                                System.out.println("");
                                printWriter.flush();
                                System.out.println("Flushed coords " + x + " " + y);
                            }
                        }
                    } else if (inputLine.equals("god") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname())) {
                        String stringInput = stdin.next();
                        System.out.println("Read GodChoice " + stringInput);
                        XmlMapper xmlMapper = (new XmlMapper());
                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                        String toSend = xmlMapper.writeValueAsString(new GodChoiceEvent(stringInput, proxyModel.getThisClientNickname()));
                        toSend += "\n";
                        printWriter.print(toSend);
                        System.out.print(toSend);
                        System.out.println("");
                        printWriter.flush();
                        System.out.println("Flushed GodChoice " + stringInput);
                    } else if (inputLine.equals("setupcoords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(proxyModel.getThisClientNickname())) {
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
                                        System.out.print(toSend);
                                        System.out.println("");
                                        printWriter.flush();
                                        System.out.println("Flushed setup coords " + x + " " + y);
                                    }
                                }
                            }
                        }
                    }
                } }
            } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
    }
}
