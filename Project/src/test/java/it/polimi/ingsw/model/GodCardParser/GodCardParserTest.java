package it.polimi.ingsw.model.GodCardParser;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GodCardParserTest {
     @Test
     public void simpleTest() throws IOException, SAXException, ParserConfigurationException {
         GodCard godCard1;
         GodCardParser godCardParser = new GodCardParser();
         godCard1 = godCardParser.selectedGodParser(God.MORTAL);
         assertEquals(godCard1.getGodName(),"Mortal");
     }
     @Test
    public void chooseRightGodtest() throws IOException, SAXException, ParserConfigurationException {
         GodCard godCard1;
         GodCardParser godCardParser = new GodCardParser();
         godCard1 = godCardParser.selectedGodParser(God.APOLLO);
         assertEquals(godCard1.getGodName(),"Apollo");
     }
}