package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.eventbeans.NoUpdatesEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.WorkerSelectionEventBean;
import it.polimi.ingsw.server.virtualview.serverevents.LoginEvent;
import it.polimi.ingsw.server.virtualview.serverevents.ServerEvent;
import it.polimi.ingsw.server.virtualview.serverevents.StringEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
    private Controller controller;
    private ActionExecutor actionExecutor;
    private EventsBuffer eventsBuffer;

    public SocketHandlerInput(Socket socket, Controller controller, ActionExecutor actionExecutor) {
        this.socket = socket;
        this.controller = controller;
        this.actionExecutor = actionExecutor;
        this.eventsBuffer = EventsBuffer.instance();
        eventsBuffer.flushBuffer();
    }

    public void run() {
        ServerStatus status = new ServerStatus();
        status.setGameIsRunning(false);

        try {
            Scanner in = new Scanner(socket.getInputStream());

            while(!status.running()){
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                String userInput = in.nextLine();
                System.out.println(userInput);
                StringReader sr = new StringReader(userInput);
                InputSource is = new InputSource(sr);
                Document document = db.parse(is);
                Node typeEventNode = document.getElementsByTagName("eventType").item(0);
                ServerEvent serverEvent = returnCorrectServerEvent(typeEventNode.getTextContent(), document);
                System.out.println(serverEvent);
                serverEvent.serverEventMethod(controller);
                System.out.println("Done");
                /*login event stringa*/
            }

            while (status.running()) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                String userInput = in.nextLine();
                StringReader sr = new StringReader(userInput);
                InputSource is = new InputSource(sr);
                Document document = db.parse(is);
                Node typeEventNode = document.getElementsByTagName("eventType").item(0);
                ServerEvent serverEvent = returnCorrectServerEvent(typeEventNode.getTextContent(), document);
                serverEvent.serverEventMethod(controller);
                System.out.println(serverEvent);
            }
            in.close();
            socket.close();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.err.println(e.getMessage());
        }
    }

    protected ServerEvent returnCorrectServerEvent(String eventType,Document doc){
        if(doc.getDocumentElement().getTagName().equals("CoordsEvent")) {
            int x,y;
            String clientID;
            x = Integer.parseInt(doc.getElementsByTagName("x").item(0).getTextContent());
            y = Integer.parseInt(doc.getElementsByTagName("y").item(0).getTextContent());
            clientID = doc.getElementsByTagName("clientID").item(0).getTextContent();
            return new it.polimi.ingsw.server.virtualview.serverevents.CoordsEvent(x,y);
        }

        if(doc.getDocumentElement().getTagName().equals("StringEvent")){
            String payload = doc.getElementsByTagName("payload").item(0).getTextContent();
            return new StringEvent(payload);
        }

        if(doc.getDocumentElement().getTagName().equals("LoginEvent")){
            String payload = doc.getElementsByTagName("payload").item(0).getTextContent();
            return new LoginEvent(payload);
        }
        return null;
    }
}
