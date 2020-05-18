package it.polimi.ingsw.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.clientinputparser.InputParser;
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

    Socket socket;
    ClientStatus status;

    public ClientHandlerOutput(Socket socket) {
        ClientStatus status = new ClientStatus();
        this.status = status;
        this.socket = socket;
    }

    public void run() {
        status.setGameIsRunning(false);

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
            while (!status.running()) {
                String inputLine = stdin.next();
                if (inputLine.equals("quit")) {
                    status.setGameIsRunning(false);
                } else {
                    if (inputLine.equals("login")) {
                        if (stdin.hasNextLine()) {
                            String nickname = stdin.next();
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new LoginEvent(nickname));
                                toSend += "\n";
                                printWriter.print(toSend);
                                System.out.print(toSend);
                                System.out.println("");
                                printWriter.flush();
                                System.out.println("Plz start the game");
                            }
                    } else if (inputLine.equals("start")) {
                        status.setGameIsRunning(true);
                    }
                } }
                while (status.running()) {
                    String inputLine = stdin.next();
                    if (inputLine.equals("quit")) {
                        status.setGameIsRunning(false);
                    } else {
                        if (inputLine.equals("coords")) {
                            if (stdin.hasNextInt()) {
                                int x = stdin.nextInt();
                                if (stdin.hasNextInt()) {
                                    int y = stdin.nextInt();
                                    System.out.println("Read coords " + x + " " + y);
                                    XmlMapper xmlMapper = (new XmlMapper());
                                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                    CoordsEvent coordsEvent = new CoordsEvent(x, y, status.getClientID());
                                    String toSend = xmlMapper.writeValueAsString(coordsEvent);
                                    toSend += '\n';
                                    printWriter.print(toSend);
                                    System.out.print(toSend);
                                    System.out.println("");
                                    printWriter.flush();
                                    System.out.println("Flushed coords " + x + " " + y);
                                }
                            }
                        } else if (inputLine.equals("string")) {
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
