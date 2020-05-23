package it.polimi.ingsw.client;

import it.polimi.ingsw.client.clientinputparser.InputParser;
import it.polimi.ingsw.client.viewevents.ViewEvent;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandlerInput implements Runnable {

    private Socket socket;
    private InputParser inputParser = new InputParser();

    public ClientHandlerInput(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        System.out.println("Connection established Input");
        Scanner in = null;
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                System.out.println("Login phase reading");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document document = db.parse(new InputSource(new StringReader(in.nextLine())));
                ViewEvent viewEvent = inputParser.retrunCorrectClientEvent(document);
                System.out.println(viewEvent);
                viewEvent.viewEventMethod();
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
