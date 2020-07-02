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



public class GodCardParser {
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
        /* refactor */ /* if (atomicPower.equals("BuildThenStop")) {
            Build tempBuild = new BuildThenStop();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        } */
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
        /* refactor */ /* if (atomicPower.equals("BuildThenDontMoveUp")) {
            Build tempBuild = new BuildThenDontMoveUp();
            selectedGodCard.getBuildList().add(tempBuild);
            return tempBuild;
        } */
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

    public BooleanRequestAction parseBooleanRequestStrategy(String atomicStrategy){
        if(atomicStrategy.equals("AskSameActionTwice"))
            return new AskSameActionTwice();
        if(atomicStrategy.equals("AskToBuildDome"))
            return new AskBuildDome();
        if(atomicStrategy.equals("AskToBuildOrMove"))
            return new AskToBuildOrMove();
        return null;
    }


    public GodCard selectedGodParser(String choosenGod){
        //File cardFile = new File(this.getClass().getClassLoader().getResource("out/artifacts/AM46_jar/GodCardList.xml").getFile());
        //file = this.getClass().getClassLoader().getResource("GodCardList.xml").getFile();
        //File cardFile = new File("src/main/java/it/polimi/ingsw/server/model/godcards/GodCardList.xml");
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
            //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
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
        /*System.out.println(i);*/
        Element eElement = (Element) nGodCardListNode;
        selectedGodCard.setGodName(eElement.getAttribute("name"));
        selectedGodCard.setDescription(eElement.getElementsByTagName("descrizione").item(0).getTextContent());
        if(eElement.getElementsByTagName("BooleanRequest").item(0) != null){
            selectedGodCard.setBooleanRequestActionStrategy(parseBooleanRequestStrategy(eElement.getElementsByTagName("BooleanRequest").item(0).getTextContent()));
        }
        if (nGodCardListNode.getNodeType() == Node.ELEMENT_NODE) {
                /*
                questo codice trova correttamente i figli di GodCard
                 */
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

    public List<String> returnGodList(){
        List<String> godList = new ArrayList<>();
        //File cardFile = new File("src/main/java/it/polimi/ingsw/server/model/godcards/GodCardList.xml");
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
