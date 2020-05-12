package it.polimi.ingsw.client;

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

public class SimpleClient {

    private String ip;
    private int port;
    ClientStatus status;
    boolean writingPhase;
    private InputParser inputParser = new InputParser();

    public SimpleClient(String ip, int port) {
        ClientStatus status = new ClientStatus();
        this.status = status;
        this.ip = ip;
        this.port = port;
    }
    public void switchPhase() {
        if(writingPhase == false) writingPhase = true;
        else writingPhase = false;
    }

    public void setClientID(String clientID) {
        status.setClientID(clientID);
    }
    public void setCurrentPlayer(String currentPlayer) {
        status.setCurrentPlayer(currentPlayer);
    }

    public boolean myTurn() {
        if(status.getClientID().equals(status.getCurrentPlayer())) return true;
        return false;
    }

    public void startClient() throws IOException {
        /* if(myTurn()) { writingPhase = true; */ /* il client parte in fase di scrittura */
        /* }  else writingPhase = false; */
        writingPhase = true;
        status.setGameIsRunning(true);
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        /* ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); */
        /* ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); */
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        Scanner stdin = new Scanner(System.in);

        try {
            while (status.running()) {
                if(writingPhase) {
                    /* System.out.println("Writing phase"); */
                    String inputLine = stdin.next();
                    if(inputLine.equals("quit")) {
                        status.setGameIsRunning(false);
                    } else {
                        if (inputLine.equals("coords")) {
                            if(stdin.hasNextInt()) {
                                int x = stdin.nextInt();
                                if (stdin.hasNextInt()) {
                                    int y = stdin.nextInt();
                                    System.out.println("Read coords " + x + " " + y);
                                    XmlMapper xmlMapper = (new XmlMapper());
                                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                    String toSend = xmlMapper.writeValueAsString(new CoordsEvent(x, y, status.getClientID()));
                                    toSend+="\n";
                                    printWriter.print(toSend);
                                    System.out.print(toSend);
                                    System.out.println("");
                                    printWriter.flush();
                                    System.out.println("Flushed coords " + x + " " + y);
                                    switchPhase();
                                }
                            }
                        } else if (inputLine.equals("string")) {
                            String stringInput = stdin.next();
                            System.out.println("Read string "+stringInput);
                            XmlMapper xmlMapper = (new XmlMapper());
                            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION,true);
                            String toSend = xmlMapper.writeValueAsString(new StringEvent(stringInput));
                            toSend+="\n";
                            printWriter.print(toSend);
                            System.out.print(toSend);
                            System.out.println("");
                            printWriter.flush();
                            System.out.println("Flushed string "+stringInput);
                            switchPhase();
                        }
                    }
                }
                else {
                    System.out.println("Reading phase");
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document document = db.parse(new InputSource(new StringReader(in.nextLine())));
                    ViewEvent viewEvent = inputParser.retrunCorrectClientEvent(document);
                    System.out.println(viewEvent);
                    if(myTurn() && viewEvent.startWaiting()) { switchPhase(); }
                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {

            /* oos.close(); */
            /* ois.close(); */
            socket.close();
        }
    }
}



