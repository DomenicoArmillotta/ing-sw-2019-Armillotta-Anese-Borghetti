package it.polimi.ingsw.client.clientinputparser;

import it.polimi.ingsw.client.viewevents.*;
import it.polimi.ingsw.server.model.mvevents.eventbeans.GameStartEventBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public ViewEvent retrunCorrectClientEvent(Document document) throws ParserConfigurationException {

        /*
        mo devo parsare per davvero , document contiene le in formazioni della stringa già parsata;
        */

        if(document.getDocumentElement().getTagName().equals("BuildBlockEventBean")){
            int x = Integer.parseInt(document.getElementsByTagName("blockX").item(0).getTextContent());
            int y = Integer.parseInt(document.getElementsByTagName("blockY").item(0).getTextContent());
            int levelToBuild = Integer.parseInt(document.getElementsByTagName("levelToBuild").item(0).getTextContent());
            return new BuildBlockViewEvent(x,y,levelToBuild);
        }
        if(document.getDocumentElement().getTagName().equals("FailedActionEventBean")){
            return new FailedActionViewEvent();
        }
        if(document.getDocumentElement().getTagName().equals("NoUpdatesEventBean")){
            return new NoUpdatesViewEvent();
        }
        if(document.getDocumentElement().getTagName().equals("PlayerLostEventBean")){
            String loserName = document.getElementsByTagName("loserName").item(0).getTextContent();
            return new PlayerLostViewEvent(loserName);
        }
        if(document.getDocumentElement().getTagName().equals("PlayerWonEventBean")){
            String winnerName = document.getElementsByTagName("winnerName").item(0).getTextContent();
            return new PlayerWonViewEvent(winnerName);
        }
        if(document.getDocumentElement().getTagName().equals("WaitingForActionEventBean")){
            /*String winnerName = document.getElementsByTagName("winnerName").item(0).getTextContent();
            <?xml version='1.0' encoding='UTF-8'?><WaitingForActionEventBean><eventType>WaitingForActionEvent</eventType><coordinates><coordinates>0</coordinates><coordinates>1</coordinates><coordinates>1</coordinates><coordinates>0</coordinates></coordinates></WaitingForActionEventBean>
            gli arriverà una lista di coordinate
            */

            List<Integer> w8CoordinatesList = new ArrayList<>();

            NodeList nodeList = document.getElementsByTagName("coordinates");
            Node internalNodeList = nodeList.item(0);
            Element e = (Element) internalNodeList;
            NodeList coordinateList = e.getElementsByTagName("coordinates");
            for (int i = 0; i < coordinateList.getLength(); i++) {
                Node internalNode = coordinateList.item(i);
                if(internalNode.getNodeType() == Node.ELEMENT_NODE){

                    Element elementoInterno = (Element) internalNode;
                    NodeList nodiInterni = elementoInterno.getElementsByTagName("x");
                    Node node1 = nodiInterni.item(0);
                    w8CoordinatesList.add(Integer.parseInt(node1.getTextContent()));

                    NodeList nodiInterni2 = elementoInterno.getElementsByTagName("y");
                    Node node2 = nodiInterni2.item(0);
                    w8CoordinatesList.add(Integer.parseInt(node2.getTextContent()));
                }
            }
            String currTurn = document.getElementsByTagName("currTurn").item(0).getTextContent();
            return new WaitingForActionViewEvent(w8CoordinatesList,currTurn);

        }
        if(document.getDocumentElement().getTagName().equals("WorkerMovementEventBean")){
            int currX = Integer.parseInt(document.getElementsByTagName("currX").item(0).getTextContent());
            int currY = Integer.parseInt(document.getElementsByTagName("currY").item(0).getTextContent());
            int prevX = Integer.parseInt(document.getElementsByTagName("prevX").item(0).getTextContent());
            int prevY = Integer.parseInt(document.getElementsByTagName("prevY").item(0).getTextContent());
            return new WorkerMovementViewEvent(prevX,prevY,currX,currY);
        }
        if(document.getDocumentElement().getTagName().equals("WorkerSelectionEventBean")){
            int currX = Integer.parseInt(document.getElementsByTagName("workerX").item(0).getTextContent());
            int currY = Integer.parseInt(document.getElementsByTagName("workerY").item(0).getTextContent());
            return new WorkerSelectionViewEvent(currX,currY);
        }
        if(document.getDocumentElement().getTagName().equals("CorrectLoginPartyOwnerEvent")){
            String partyOwner = document.getElementsByTagName("partyOwner").item(0).getTextContent();
            String loggedPlayer = document.getElementsByTagName("loggedPlayer").item(0).getTextContent();

            return new PartyLoginViewEvent(partyOwner,loggedPlayer);
        }
        if(document.getDocumentElement().getTagName().equals("TakenNickNameEvent")){
            String takenNickNamePlayer = document.getElementsByTagName("takenNickNamePlayer").item(0).getTextContent();

            return new TakenNickNameViewEvent(takenNickNamePlayer);
        }
        if(document.getDocumentElement().getTagName().equals("GameStartEventBean")){
            String firstPlayer = document.getElementsByTagName("firstPlayer").item(0).getTextContent();
            String secondPlayer = document.getElementsByTagName("secondPlayer").item(0).getTextContent();
            String thirdPlayer = document.getElementsByTagName("thirdPlayer").item(0).getTextContent();

            return new SetupStartViewEvent(firstPlayer, secondPlayer, thirdPlayer);
        }
        if(document.getDocumentElement().getTagName().equals("GodCorrectlyChosen")){
            String chosenGod = document.getElementsByTagName("chosenGod").item(0).getTextContent();
            String player = document.getElementsByTagName("player").item(0).getTextContent();

            return new GodChosenViewEvent(chosenGod, player);
        }
        if(document.getDocumentElement().getTagName().equals("EveryGodChosenEventBean")){

            return new TrueGameStartEvent();
        }
        if(document.getDocumentElement().getTagName().equals("SetupWorkerDoneEventBean")){
            int x = Integer.parseInt(document.getElementsByTagName("x").item(0).getTextContent());
            int y = Integer.parseInt(document.getElementsByTagName("y").item(0).getTextContent());
            int z = Integer.parseInt(document.getElementsByTagName("z").item(0).getTextContent());
            int w = Integer.parseInt(document.getElementsByTagName("w").item(0).getTextContent());
            String ownerName = document.getElementsByTagName("ownerName").item(0).getTextContent();
            return new WorkersSetupViewEvent(x, y, z, w, ownerName);
        }
        if(document.getDocumentElement().getTagName().equals("DoubleMoveEventBean")){
            String doubleMethod = document.getElementsByTagName("doubleMethod").item(0).getTextContent();
            return new DoubleMoveViewEvent(doubleMethod);
        }
        return null;
    }

}
