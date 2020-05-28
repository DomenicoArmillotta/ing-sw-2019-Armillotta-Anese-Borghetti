package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class BuildDomePromptTest {
    @Test
    public void simpleDomePromptest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        Player player = new Player("pippofono");
        player.setPlayerGod(godCardsDeck.createGodCard("atlas"));
        assertNotNull(player.getPlayerGod().getBooleanRequestActionStrategy());
    }

}