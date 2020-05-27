package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.virtualview.serverevents.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandlerInput implements Runnable {
    private Socket socket;
    private Controller  controller;
    private EventsBuffer eventsBuffer;

    public SocketHandlerInput(Socket socket, Controller controller) {
        this.socket = socket;
        this.controller = controller;
        this.eventsBuffer = EventsBuffer.instance();
        eventsBuffer.flushBuffer();
    }

    public void run() {

        try {
            Scanner in = new Scanner(socket.getInputStream());

            while(true) {
                System.out.println("Ready to read");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                String userInput = in.nextLine();
                System.out.println(userInput);
                StringReader sr = new StringReader(userInput);
                InputSource is = new InputSource(sr);
                Document document = db.parse(is);
                ServerEvent serverEvent = returnCorrectServerEvent(document);
                System.out.println(serverEvent);
                serverEvent.serverEventMethod(controller);
                System.out.println("Done");
            }
            /* Andrà reinserita la chiusura dei canali quando sapremo dove metterla */
            /* in.close();
            socket.close(); */
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.err.println(e.getMessage());
        }
    }

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

        if(doc.getDocumentElement().getTagName().equals("StringEvent")){
            String payload = doc.getElementsByTagName("payload").item(0).getTextContent();
            return new StringEvent(payload);
        }

        if(doc.getDocumentElement().getTagName().equals("LoginEvent")){
            String payload = doc.getElementsByTagName("payload").item(0).getTextContent();
            return new LoginEvent(payload);
        }
        if(doc.getDocumentElement().getTagName().equals("StartUpEvent")){
            String playerComm = doc.getElementsByTagName("playerComm").item(0).getTextContent();
            return new StartUpEvent(playerComm);
        }
        if(doc.getDocumentElement().getTagName().equals("GodChoiceEvent")){
            String chosenGod = doc.getElementsByTagName("chosenGod").item(0).getTextContent();
            String player = doc.getElementsByTagName("player").item(0).getTextContent();
            return new GodChoiceEvent(chosenGod, player);
        }
        return null;
    }
}
