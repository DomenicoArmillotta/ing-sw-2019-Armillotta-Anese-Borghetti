package it.polimi.ingsw.server.model.godcards;

import it.polimi.ingsw.server.model.powertree.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class GodCardParser {
    private Power returnCorrectAtomicPower(String atomicPower,GodCard selectedGodCard) {


        if (atomicPower.equals("FindAvailableCellsMove")) {
            FindAvailableCells tempCell = new FindAvailableCellsMove();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("FindAvailableCellsMoveButDontMoveUp")) {
            FindAvailableCells tempCell = new FindAvailableCellsMoveButDontMoveUp();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("FindAvailableCellsMovePush")) {
            FindAvailableCells tempCell = new FindAvailableCellsMovePush();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;

        }
        if (atomicPower.equals("FindAvailableCellsMoveSwitch")) {
            FindAvailableCells tempCell = new FindAvailableCellsMoveSwitch();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }if (atomicPower.equals("FindAvailableCellDontMoveBack")) {
            FindAvailableCells tempCell = new FindAvailableCellsDontMoveBack();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }

        if (atomicPower.equals("Select")) {
            Select tempSelect = new Select();
            selectedGodCard.getSelectList().add(tempSelect);
            return tempSelect;
        }
        if (atomicPower.equals("Move")) {
            Move tempMove = new Move();
            selectedGodCard.getMoveList().add(tempMove);
            return tempMove;
        }
        if (atomicPower.equals("MovePush")) {
            Move tempMove = new MovePush();
            selectedGodCard.getMoveList().add(tempMove);
            return tempMove;
        }
        if (atomicPower.equals("MoveCheckingLevel")) {
            Move tempMove = new MoveCheckingLevel();
            selectedGodCard.getMoveList().add(tempMove);
            return tempMove;
        }
        if (atomicPower.equals("MoveSwitch")) {
            Move tempMove = new MoveSwitch();
            selectedGodCard.getMoveList().add(tempMove);
            return tempMove;
        }
        if (atomicPower.equals("MoveButDontGoBack")) {
            Move tempMove = new MoveButDontGoBack();
            selectedGodCard.getMoveList().add(tempMove);
            return tempMove;
        }
        if (atomicPower.equals("WinCondition")) {
            WinCondition tempWin = new WinCondition();
            selectedGodCard.getWinConditionList().add(tempWin);
            return tempWin;
        }
        if (atomicPower.equals("WinIfTwoLevelsDown")) {
            WinCondition tempWin = new WinIfTwoLevelsDown();
            selectedGodCard.getWinConditionList().add(tempWin);
            return tempWin;
        }
        if (atomicPower.equals("Build")) {
            Build tempBuild = new Build();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        }
        if (atomicPower.equals("BuildOnADifferentCell")) {
            Build tempBuild = new BuildOnDifferentCell();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        }
        if (atomicPower.equals("BuildOnSameCell")) {
            Build tempBuild = new BuildOnSameCell();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        }
        if (atomicPower.equals("BuildThenDontMoveUp")) {
            Build tempBuild = new BuildThenDontMoveUp();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        }
        if (atomicPower.equals("DontBuildDome")) {
            Build tempBuild = new DontBuildDome();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        }
        if (atomicPower.equals("InstantBuildDome")) {
            Build tempBuild = new InstantBuildDome();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        }
        if (atomicPower.equals("FindAvailableCellsBuild")) {
            FindAvailableCells tempCell = new FindAvailableCellsBuild();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("FindAvailableCellsBuildDifferentCell")) {
            FindAvailableCells tempCell = new FindAvailableCellsBuildDifferentCell();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("FindAvailableCellsBuildSameCell")) {
            FindAvailableCells tempCell = new FindAvailableCellsBuildSameCell();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("FindAvailableCellsBuildInstantDome")) {
            FindAvailableCells tempCell = new FindAvailableCellsBuildInstantDome();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("DoubleMove")) {
            return new DoubleMove();
        }
        if (atomicPower.equals("BuildDomePrompt")) {
            return new BuildDomePrompt();
        }
        return null;
    }

    public BooleanRequestAction parseBooleanRequestStrategy(String atomicStrategy){
        if(atomicStrategy.equals("AskSameActionTwice"))
            return new AskSameActionTwice();
        if(atomicStrategy.equals("AskToBuildDome"))
            return new AskBuildDome();
        return null;
    }


    public GodCard selectedGodParser(String choosenGod) throws ParserConfigurationException, IOException, SAXException {
        File cardFile = new File("src/main/java/it/polimi/ingsw/server/model/godcards/GodCardList.xml");
        int i;
        int j;
        int k;
        boolean selectable = false;
        List<Power> temporaryPowerList = new ArrayList<>();
        GodCard selectedGodCard = new GodCard();
        selectedGodCard.setupLists();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbf.newDocumentBuilder();
        Document document = dBuilder.parse(cardFile);
        //document.getDocumentElement().normalize();
        /*System.out.println("ROOT  ELEMENT : " + document.getDocumentElement().getNodeName());*/
        NodeList godCardList = document.getElementsByTagName("Godcard");
        for (i = 0; i < godCardList.getLength() && !selectable; i++) {
            Node nGodCardListNode = godCardList.item(i);
            Element eElement = (Element) nGodCardListNode;
            if (eElement.getAttribute("name").toLowerCase().equals(choosenGod.toLowerCase())) {
                /*
                se la divinità e quella deve uscire dal ciclo for
                 */
                selectable = true;
            }
        }
        //reinizializzo alla godCard con l'attributo desiderato
        Node nGodCardListNode = godCardList.item(i - 1);
        /*System.out.println(i);*/
        Element eElement = (Element) nGodCardListNode;
        selectedGodCard.setGodName(eElement.getAttribute("name"));
        selectedGodCard.setDescription(eElement.getElementsByTagName("descrizione").item(0).getTextContent());
        if(eElement.getElementsByTagName("BooleanRequest").item(0) != null){
            selectedGodCard.setBooleanRequestActionStrategy(parseBooleanRequestStrategy(eElement.getElementsByTagName("BooleanRequest").item(0).getTextContent()));
        }
        /*System.out.println("NODECARDNAME " + eElement.getAttribute("name"));*/
        if (nGodCardListNode.getNodeType() == Node.ELEMENT_NODE) {
                /*
                questo codice trova correttamente i figli di GodCard
                 */
            NodeList contenutoLista = (((Element) nGodCardListNode).getElementsByTagName("PowerList"));
            Node tempNodeList = contenutoLista.item(0);
            /*System.out.println("dovrebbe essere powerList " + tempNodeList.getNodeName());
            System.out.println("dimension e powerlist " + contenutoLista.getLength());*/
            for (j = 0; j < contenutoLista.getLength(); j++) {
                Node tempNode = contenutoLista.item(j);
                if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element actualPowerList = (Element) contenutoLista.item(0);
                    /*System.out.println("n nodi filgi di powerList");*/
                    NodeList atomicNodeList = actualPowerList.getChildNodes();
                    for (k = 0; k < atomicNodeList.getLength(); k++) {
                        if (atomicNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                            /*qui dentro passo i poteri atomici;*/
                            temporaryPowerList.add(returnCorrectAtomicPower(atomicNodeList.item(k).getNodeName(),selectedGodCard));
                            /*System.out.println(atomicNodeList.item(k).getNodeName());*/
                        }
                    }
                }
            }
        }
        selectedGodCard.setPowerList(temporaryPowerList);
        return selectedGodCard;
    }
}
