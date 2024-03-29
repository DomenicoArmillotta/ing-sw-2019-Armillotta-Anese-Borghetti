package it.polimi.ingsw.client;

import it.polimi.ingsw.client.clientinputparser.InputParser;
import it.polimi.ingsw.client.proxymodel.Phase;
import it.polimi.ingsw.client.proxymodel.ProxyModel;
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

/**
 * ClientHandlerInput it's used for reading the input stream of the server
 */
public class ClientHandlerInput implements Runnable {

    private Socket socket;
    private InputParser inputParser = new InputParser();

    public ClientHandlerInput(Socket socket) {
        this.socket = socket;
    }

    /**
     * thanks to the parser it decodes the information it reads from the server and creates the viewEvent
     * close the socket when the server is not connected
     */
    public void run() {

        /* System.out.println("[ClientHandlerInput] Connection established"); */
        Scanner in = null;
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (ProxyModel.instance().getPhase().ordinal() != Phase.DISCONNECTED.ordinal()) {
                /* System.out.println("Login phase reading"); */
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document document = db.parse(new InputSource(new StringReader(in.nextLine())));
                ViewEvent viewEvent = inputParser.retrunCorrectClientEvent(document);
                /* System.out.println(viewEvent); */
                viewEvent.viewEventMethod();
            }
            in.close();
            ProxyModel.instance().getPrintWrite().close();
            //System.out.println("questo client "+socket+" si è disconneso");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.getMessage();
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
