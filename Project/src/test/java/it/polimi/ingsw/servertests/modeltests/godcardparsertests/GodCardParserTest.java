package it.polimi.ingsw.servertests.modeltests.godcardparsertests;

import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardParser;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GodCardParserTest {
     @Test
     public void simpleTest(){
         GodCard godCard1;
         GodCardParser godCardParser = new GodCardParser();
         godCard1 = godCardParser.selectedGodParser(God.MORTAL.toString());
         assertEquals(godCard1.getGodName(),"Mortal");

     }
     @Test
     public void chooseRightGodtest(){
         GodCard godCard1;
         GodCardParser godCardParser = new GodCardParser();
         godCard1 = godCardParser.selectedGodParser(God.APOLLO.toString());
         assertEquals(godCard1.getGodName(),"Apollo");
     }
     @Test
    public void checkIfSubListsAreCorrectlyCreated(){
         GodCard godCard;
         GodCardParser godCardParser = new GodCardParser();
         for(God god : God.values()){
             godCard = new GodCard();
             godCard = godCardParser.selectedGodParser(god.toString());
             assertEquals(godCard.getPowerList().get(0),godCard.getFindAvailableCellsList().get(0));
         }
     }
}