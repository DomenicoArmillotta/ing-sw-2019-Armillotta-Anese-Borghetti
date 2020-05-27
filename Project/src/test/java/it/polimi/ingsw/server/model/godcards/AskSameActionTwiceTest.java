package it.polimi.ingsw.server.model.godcards;

import it.polimi.ingsw.servertests.modeltests.godcardparsertests.GodCardsDeckTest;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AskSameActionTwiceTest {
    @Test
    public void simpleBooleanStrategyTest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        GodCard godCard = godCardsDeck.createGodCard("artemis");
        assertNotNull(godCard.getBooleanRequestActionStrategy());
    }
}