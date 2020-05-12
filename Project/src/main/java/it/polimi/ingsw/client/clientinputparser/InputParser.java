package it.polimi.ingsw.client.clientinputparser;

import it.polimi.ingsw.client.viewevents.*;
import it.polimi.ingsw.server.model.mvevents.actionevents.BuildBlockEvent;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class InputParser {
    private Document document;

    public ViewEvent retrunCorrectClientEvent() throws ParserConfigurationException {
        /*
        mo devo parsare per davvero , document contiene le in formazioni della stringa già parsata;
        */
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("BuildBlockEvent")){
            int x = Integer.parseInt(document.getElementsByTagName("x").item(0).getTextContent());
            int y = Integer.parseInt(document.getElementsByTagName("y").item(0).getTextContent());
            return new BuildBlockViewEvent(x,y);
        }
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("FailedActionEvent")){
            return new FailedActionViewEvent();
        }
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("NoUpdatesEvent")){
            return new NoUpdatesViewEvent();
        }
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("PlayerLostEvent")){
            String loserName = document.getElementsByTagName("loserName").item(0).getTextContent();
            return new PlayerLostViewEvent(loserName);
        }
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("PlayerWonEvent")){
            String winnerName = document.getElementsByTagName("winnerName").item(0).getTextContent();
            return new PlayerWonViewEvent(winnerName);
        }
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("WaitingForActionEvent")){
            String winnerName = document.getElementsByTagName("winnerName").item(0).getTextContent();
            return null;
        }
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("WorkerMovementEvent")){
            int currX = Integer.parseInt(document.getElementsByTagName("currX").item(0).getTextContent());
            int currY = Integer.parseInt(document.getElementsByTagName("currY").item(0).getTextContent());
            int prevX = Integer.parseInt(document.getElementsByTagName("prevX").item(0).getTextContent());
            int prevY = Integer.parseInt(document.getElementsByTagName("prevY").item(0).getTextContent());
            return new WorkerMovementViewEvent(prevX,prevY,currX,currY);
        }
        if(document.getElementsByTagName("eventType").item(0).getTextContent().equals("WorkerSelectionEvent")){
            int currX = Integer.parseInt(document.getElementsByTagName("workerX").item(0).getTextContent());
            int currY = Integer.parseInt(document.getElementsByTagName("workerY").item(0).getTextContent());
            return new WorkerSelectionViewEvent(currX,currY);
        }
        return null;
    }
}
