package it.polimi.ingsw.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.clientinputparser.InputParser;
import it.polimi.ingsw.client.proxymodel.ProxyModel;
import it.polimi.ingsw.client.viewevents.ViewEvent;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandlerOutput implements Runnable {

    private Socket socket;
    private ClientStatus clientStatus;
    private ProxyModel proxyModel;


    public ClientHandlerOutput(Socket socket, ClientStatus clientStatus, ProxyModel proxyModel) {
        this.socket = socket;
        this.clientStatus = clientStatus;
        this.proxyModel = proxyModel;
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
        Scanner stdin = new Scanner(System.in);

        try {

            while (clientStatus.getGamePhase().equals(GamePhase.LOGIN)) {
                String inputLine = stdin.next();
                if (inputLine.equals("quit")) {
                    clientStatus.setGamePhase(GamePhase.DISCONNECTED);
                    break;
                } else {
                    if (inputLine.equals("login") && clientStatus.getThisClientNickname().equals("")) {
                        if (stdin.hasNextLine()) {
                                inputLine = stdin.next();
                                clientStatus.setThisClientNickname(inputLine);
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new LoginEvent(clientStatus.getThisClientNickname()));
                                toSend += "\n";
                                printWriter.print(toSend);
                                System.out.print(toSend);
                                System.out.println("");
                                printWriter.flush();
                            }
                    } else if (inputLine.equals("start") && clientStatus.getThisClientNickname().equals(clientStatus.getPartyOwner())) { /* playerComm */
                        XmlMapper xmlMapper = (new XmlMapper());
                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                            String toSend = xmlMapper.writeValueAsString(new StartUpEvent(clientStatus.getThisClientNickname()));
                            toSend += "\n";
                            printWriter.print(toSend);
                            System.out.print(toSend);
                            System.out.println("");
                            printWriter.flush();
                    } else if (inputLine.equals("coords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(clientStatus.getThisClientNickname())) {
                        if (stdin.hasNextInt()) {
                            int x = stdin.nextInt();
                            if (stdin.hasNextInt()) {
                                int y = stdin.nextInt();
                                System.out.println("Read coords " + x + " " + y);
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                //GameCoordsEvent gameCoordsEvent = new GameCoordsEvent(x, y);
                                String toSend = xmlMapper.writeValueAsString(new GameCoordsEvent(x, y));
                                //String toSend = xmlMapper.writeValueAsString(new StartUpEvent(clientStatus.getThisClientNickname()));
                                toSend += "\n";
                                printWriter.print(toSend);
                                System.out.print(toSend);
                                System.out.println("");
                                printWriter.flush();
                                System.out.println("Flushed coords " + x + " " + y);
                            }
                        }
                    } else if (inputLine.equals("string") && proxyModel.getTurn().getCurrentPlayer().equals(clientStatus.getThisClientNickname())) {
                        String stringInput = stdin.next();
                        System.out.println("Read string " + stringInput);
                        XmlMapper xmlMapper = (new XmlMapper());
                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                        String toSend = xmlMapper.writeValueAsString(new StringEvent(stringInput));
                        toSend += "\n";
                        printWriter.print(toSend);
                        System.out.print(toSend);
                        System.out.println("");
                        printWriter.flush();
                        System.out.println("Flushed string " + stringInput);
                    }
                } }


                while (clientStatus.getGamePhase().equals(GamePhase.GAME)) {
                    System.out.println("Game phase");
                    String inputLine = stdin.next();
                    if (inputLine.equals("quit")) {
                        clientStatus.setGamePhase(GamePhase.DISCONNECTED);
                        /* send client logout event to server */
                        break;
                    } else {
                        if (inputLine.equals("coords") && proxyModel.getTurn().getCurrentPlayer().getName().equals(clientStatus.getThisClientNickname())) {
                            if (stdin.hasNextInt()) {
                                int x = stdin.nextInt();
                                if (stdin.hasNextInt()) {
                                    int y = stdin.nextInt();
                                    System.out.println("Read coords " + x + " " + y);
                                    XmlMapper xmlMapper = (new XmlMapper());
                                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                    GameCoordsEvent gameCoordsEvent = new GameCoordsEvent(x, y);
                                    String toSend = xmlMapper.writeValueAsString(gameCoordsEvent);
                                    toSend += '\n';
                                    printWriter.print(toSend);
                                    System.out.print(toSend);
                                    System.out.println("");
                                    printWriter.flush();
                                    System.out.println("Flushed coords " + x + " " + y);
                                }
                            }
                        } else if (inputLine.equals("string") && proxyModel.getTurn().getCurrentPlayer().equals(clientStatus.getThisClientNickname())) {
                            String stringInput = stdin.next();
                            System.out.println("Read string " + stringInput);
                            XmlMapper xmlMapper = (new XmlMapper());
                            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                            String toSend = xmlMapper.writeValueAsString(new StringEvent(stringInput));
                            toSend += "\n";
                            printWriter.print(toSend);
                            System.out.print(toSend);
                            System.out.println("");
                            printWriter.flush();
                            System.out.println("Flushed string " + stringInput);
                        }
                    }
                }
            } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
    }
}
