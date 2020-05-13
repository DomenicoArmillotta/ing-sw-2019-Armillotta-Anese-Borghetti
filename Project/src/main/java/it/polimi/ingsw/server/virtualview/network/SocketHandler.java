package it.polimi.ingsw.server.virtualview.network;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.CoordsEvent;
import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.WorkerSelectionEventBean;
import it.polimi.ingsw.server.virtualview.serverevents.ServerEvent;
import it.polimi.ingsw.server.virtualview.serverevents.StringEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler implements Runnable {
    private Socket socket;
    private Controller controller;
    private ActionExecutor actionExecutor;
    private EventsBuffer eventsBuffer;
    boolean writingPhase;
    public SocketHandler(Socket socket, Controller controller, ActionExecutor actionExecutor) {
        this.socket = socket;
        this.controller = controller;
        this.actionExecutor = actionExecutor;
        this.eventsBuffer = EventsBuffer.instance();
        eventsBuffer.flushBuffer();
        writingPhase = false;
    }
    public void switchPhase() {
        if(writingPhase == false) writingPhase = true;
        else writingPhase = false;
    }
    public void run() {
        ServerStatus status = new ServerStatus();
        status.setGameIsRunning(true);

        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            /* DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder(); */
            /* eventsBuffer.setLastEventBean(new WorkerSelectionEventBean(2,3)); */
            while (status.running()) {
                if(writingPhase) {
                    if(eventsBuffer.getLastEventBean() != null) {
                        System.out.println("Sending bean");
                        XmlMapper xmlMapper = (new XmlMapper());
                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                        String toSend = xmlMapper.writeValueAsString(eventsBuffer.getLastEventBean());
                        toSend+="\n";
                        printWriter.print(toSend);
                        System.out.print(toSend);
                        System.out.println("");
                        printWriter.flush();
                        System.out.println("Flushed bean");
                        if(eventsBuffer.isWaiting()) {
                            switchPhase();
                        }
                    }
                } else {
                    //System.out.println("Reading phase");
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document document = db.parse(new InputSource(new StringReader(in.nextLine())));
                    Node typeEventNode = document.getElementsByTagName("eventType").item(0);
                    ServerEvent serverEvent = returnCorrectServerEvent(typeEventNode.getTextContent(), document);
                    serverEvent.serverEventMethod(controller);
                    switchPhase();
                }
            }
            in.close();
            socket.close();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.err.println(e.getMessage());
        }
    }

    protected ServerEvent returnCorrectServerEvent(String eventType,Document doc){
        if(eventType.equals("CoordsEvent")) {
            int x,y;
            String clientID;
            x = Integer.parseInt(doc.getElementsByTagName("x").item(0).getTextContent());
            y = Integer.parseInt(doc.getElementsByTagName("y").item(0).getTextContent());
            clientID = doc.getElementsByTagName("clientID").item(0).getTextContent();
            if(clientID.equals(actionExecutor.getCurrentPlayer().getName())) return new it.polimi.ingsw.server.virtualview.serverevents.CoordsEvent(x,y);
        }
        if(eventType.equals("StringEvent")){
            String payload = doc.getElementsByTagName("payload").item(0).getTextContent();
            return new StringEvent(payload);
        }
        return null;
    }
}
