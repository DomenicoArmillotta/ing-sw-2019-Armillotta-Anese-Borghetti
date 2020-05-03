package it.polimi.ingsw.model.GodCardParser;

import it.polimi.ingsw.model.powertree.*;
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
    /*
    qui faccio il parser delle carte dal file xml;

    cosa faccio???

    conettrà tutti i metodi pe4r parsare

     */
    private Power returnCorrectAtomicPower(String atomicPower) {
        if (atomicPower.equals("FindAvailableCellsMove"))
            return new FindAvailableCellsMove();
        if (atomicPower.equals("FindAvailableCellsMoveButDontMoveUp"))
            return new FindAvailableCellsMoveButDontMoveUp();
        if (atomicPower.equals("FindAvailableCellsMovePush"))
            return new FindAvailableCellsMovePush();
        if (atomicPower.equals("FindAvailableCellsMoveSwitch"))
            return new FindAvailableCellsMoveSwitch();
        if (atomicPower.equals("Select"))
            return new Select();
        if (atomicPower.equals("Move"))
            return new Move();
        if (atomicPower.equals("MovePush"))
            return new MovePush();
        if (atomicPower.equals("MoveSwitch"))
            return new MoveSwitch();
        if (atomicPower.equals("WinCondition"))
            return new WinCondition();
        if (atomicPower.equals("WinIfTwoLevelsDown"))
            return new WinIfTwoLevelsDown();
        if (atomicPower.equals("Build"))
            return new Build();
        if (atomicPower.equals("BuildOnDifferentCells"))
            return new BuildOnDifferentCell();
        if (atomicPower.equals("BuildOnSameCell"))
            return new BuildOnSameCell();
        if (atomicPower.equals("BuildThenDontMoveUp"))
            return new BuildThenDontMoveUp();
        if (atomicPower.equals("DontBuildDome"))
            return new DontBuildDome();
        if (atomicPower.equals("InstantBuildDome"))
            return new InstantBuildDome();
        if (atomicPower.equals("FindAvailableCellsBuild"))
            return new FindAvailableCellsBuild();
        return null;
    }


    public GodCard selectedGodParser(God choosenGod) throws ParserConfigurationException, IOException, SAXException {
        File cardFile = new File("src/main/java/it/polimi/ingsw/model/GodCardParser/GodCardList.xml");
        int i;
        int j;
        int k;
        boolean selectable = false;
        List<Power> temporaryPowerList = new ArrayList<>();
        GodCard selectedGodCard = new GodCard();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbf.newDocumentBuilder();
        Document document = dBuilder.parse(cardFile);
        //document.getDocumentElement().normalize();
        /*System.out.println("ROOT  ELEMENT : " + document.getDocumentElement().getNodeName());*/
        NodeList godCardList = document.getElementsByTagName("Godcard");
        for (i = 0; i < godCardList.getLength() && !selectable; i++) {
            Node nGodCardListNode = godCardList.item(i);
            Element eElement = (Element) nGodCardListNode;
            if (eElement.getAttribute("name").toLowerCase().equals(choosenGod.toString().toLowerCase())) {
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
                            temporaryPowerList.add(returnCorrectAtomicPower(atomicNodeList.item(k).getNodeName()));
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







        /*
        for (i = 0; i < nodeList.getLength() && !a; i++) {
            Element tempElement = (Element) nodeList.item(i);

            questo codice  35 a 37 controlla che il nome selzionato sua == a quello di Godcard e in i c'è l'iformazione

            if (tempElement.getAttributeNode("name").getTextContent().equals(choosenGod.toString().toLowerCase())) {
                a = true;
            }
        }

        //System.out.println(tempNodelist.item(j).getNodeName());
                //System.out.println(tempNodes.getNodeName());
                Element tempNode = (Element) tempNodelist.item(j);
                System.out.println(tempNode.getTextContent());
                //System.out.println(tempNodes.getTextContent());













                  public void selectedGodParser(God choosenGod) throws ParserConfigurationException, IOException, SAXException {
        File cardFile = new File("src/main/java/it/polimi/ingsw/model/GodCardParser/GodCardList.xml");
        int i;
        int j;
        boolean selectable = false;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbf.newDocumentBuilder();
        Document document = dBuilder.parse(cardFile);
        //document.getDocumentElement().normalize();
        System.out.println("ROOT  ELEMENT : " + document.getDocumentElement().getNodeName());
        NodeList godCardList = document.getElementsByTagName("Godcard");
        for(i = 0; i < godCardList.getLength() ; i++ ){
            Node nGodCardListNode = godCardList.item(i);
            Element eElement = (Element) nGodCardListNode;
            System.out.println("NODECARDNAME "+eElement.getAttribute("name"));
            if(nGodCardListNode.getNodeType() == Node.ELEMENT_NODE){

                questo codice trova correttamente i figli di GodCard

        NodeList contenutoLista = (((Element) nGodCardListNode).getElementsByTagName("PowerList"));
    Node tempNodeList = contenutoLista.item(0);
               System.out.println("dovrebbe essere powerList "+tempNodeList.getNodeName());
                       System.out.println("dimension e powerlist "+ contenutoLista.getLength());
                       for(j = 0 ; j < contenutoLista.getLength() ; j++){
        Node tempNode = contenutoLista.item(j);
        if(tempNode.getNodeType() == Node.ELEMENT_NODE){
        Element actualPowerList = (Element) contenutoLista.item(0);
        System.out.println("n nodi filgi di powerList");
        NodeList atomicNodeList = actualPowerList.getChildNodes();
        for (int k = 0; k < atomicNodeList.getLength(); k++) {
        if (atomicNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
        System.out.println("k " + atomicNodeList.item(k).getNodeName());
        }
        }
        }
        }
        }
        }
        }
        }



      */