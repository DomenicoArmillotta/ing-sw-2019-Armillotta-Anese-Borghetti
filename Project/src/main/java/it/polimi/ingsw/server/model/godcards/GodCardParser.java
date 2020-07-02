package it.polimi.ingsw.server.model.godcards;

import it.polimi.ingsw.server.model.powertree.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * contains all the method necessary to create a godCard with all its powers.
 * uses DOM Parser for reading and parsing the xml file (GodListEvent)
 */

public class GodCardParser {
    /**
     * add in the correct position of the GodCard the power contained in the String atomicPower
     * @param atomicPower String that contains the power to create;
     * @param selectedGodCard the requested godCard;
     * @return a power or null if atomicPower is non containend in this list
     */
    private Power returnCorrectAtomicPower(String atomicPower,GodCard selectedGodCard) {


        if (atomicPower.equals("FindAvailableCellsMove")) {
            FindAvailableCells tempCell = new FindAvailableCellsMove();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("FindAvailableCellsMoveOptions")) {
            FindAvailableCells tempCell = new FindAvailableCellsMoveOptions();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("FindAvailableCellsSelectOptions")) {
            FindAvailableCells tempCell = new FindAvailableCellsSelectOptions();
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
        if (atomicPower.equals("SelectThenSkip")) {
            Select tempSelect = new SelectThenSkip();
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

        if (atomicPower.equals("BuildOnDifferentCell")) {
            Build tempBuild = new BuildOnDifferentCell();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        }
        if (atomicPower.equals("BuildOnSameCell")) {
            Build tempBuild = new BuildOnSameCell();
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
        if (atomicPower.equals("FindAvailableCellsBuildBeforeMove")) {
            FindAvailableCells tempCell = new FindAvailableCellsBuildBeforeMove();
            selectedGodCard.getFindAvailableCellsList().add(tempCell);
            return tempCell;
        }
        if (atomicPower.equals("DoubleMove")) {
            return new DoubleMove();
        }
        if (atomicPower.equals("BuildDomePrompt")) {
            return new BuildDomePrompt();
        }
        if (atomicPower.equals("DoubleBuild")) {
            return new DoubleBuild();
        }
        if (atomicPower.equals("BuildOrMovePrompt")) {
            return new BuildOrMovePrompt();
        }
        return null;
    }

    /**
     * create a new BooleanRequestStrategy
     * @param atomicStrategy contains the name of the BooleanRequestStrategy
     * @return new BooleanRequestStrategy
     */
    public BooleanRequestAction parseBooleanRequestStrategy(String atomicStrategy){
        if(atomicStrategy.equals("AskSameActionTwice"))
            return new AskSameActionTwice();
        if(atomicStrategy.equals("AskToBuildDome"))
            return new AskBuildDome();
        if(atomicStrategy.equals("AskToBuildOrMove"))
            return new AskToBuildOrMove();
        return null;
    }

    /**
     * loads GodCardList.xml and start parsing using DOM parser, call parseBooleanRequestStrategy and returnCorrectAtomicPower
     * for creating the requested god card
     * @param choosenGod name of the godCard
     * @return a GodCard of that particular god and  fully populated with powers
     */
    public GodCard selectedGodParser(String choosenGod){

        int i;
        int j;
        int k;
        boolean selectable = false;

        List<Power> temporaryPowerList = new ArrayList<>();
        GodCard selectedGodCard = new GodCard();
        selectedGodCard.setupLists();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }

        Document document = null;
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream inputStream  = classLoader.getResourceAsStream("GodCardList.xml");
            document = dBuilder.parse(inputStream);
        } catch (SAXException | IOException e) {
            System.out.println("loading XmlFile error ");
            e.printStackTrace();
            return null;
        }



        NodeList godCardList = document.getElementsByTagName("Godcard");
        for (i = 0; i < godCardList.getLength() && !selectable; i++) {
            Node nGodCardListNode = godCardList.item(i);
            Element eElement = (Element) nGodCardListNode;
            if (eElement.getAttribute("name").toLowerCase().equals(choosenGod.toLowerCase())) {

                selectable = true;
            }
        }
        Node nGodCardListNode = godCardList.item(i - 1);
        Element eElement = (Element) nGodCardListNode;
        selectedGodCard.setGodName(eElement.getAttribute("name"));
        selectedGodCard.setDescription(eElement.getElementsByTagName("descrizione").item(0).getTextContent());
        if(eElement.getElementsByTagName("BooleanRequest").item(0) != null){
            selectedGodCard.setBooleanRequestActionStrategy(parseBooleanRequestStrategy(eElement.getElementsByTagName("BooleanRequest").item(0).getTextContent()));
        }
        if (nGodCardListNode.getNodeType() == Node.ELEMENT_NODE) {

            NodeList contenutoLista = (((Element) nGodCardListNode).getElementsByTagName("PowerList"));
            Node tempNodeList = contenutoLista.item(0);
            System.out.println("dimension e powerlist " + contenutoLista.getLength());
            for (j = 0; j < contenutoLista.getLength(); j++) {
                Node tempNode = contenutoLista.item(j);
                if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element actualPowerList = (Element) contenutoLista.item(0);
                    NodeList atomicNodeList = actualPowerList.getChildNodes();
                    for (k = 0; k < atomicNodeList.getLength(); k++) {
                        if (atomicNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                            temporaryPowerList.add(returnCorrectAtomicPower(atomicNodeList.item(k).getNodeName(),selectedGodCard));
                        }
                    }
                }
            }
        }
        selectedGodCard.setPowerList(temporaryPowerList);
        return selectedGodCard;
    }

    /**
     * create a list of strings containing the name of all available gods
     * @return list of available gods name
     */
    public List<String> returnGodList(){
        List<String> godList = new ArrayList<>();
        System.out.println("cerco di creare una carta");



        int i;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("error creating ");
            e.printStackTrace();
            return null;
        }


        Document document = null;

        try {
            //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream inputStream  = classLoader.getResourceAsStream("GodCardList.xml");
            document = dBuilder.parse(inputStream);
        } catch (SAXException | IOException e) {
            System.out.println("error loading Xml file");
            e.printStackTrace();
            return null;
        }



        NodeList godCardList = document.getElementsByTagName("Godcard");
        for (i = 0; i < godCardList.getLength(); i++) {
            Node nGodCardListNode = godCardList.item(i);
            Element eElement = (Element) nGodCardListNode;
            godList.add(eElement.getAttribute("name").toLowerCase());

        }
        return godList;
    }
}
