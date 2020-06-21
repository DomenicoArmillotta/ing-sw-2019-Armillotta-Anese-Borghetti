package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleMoveTest {
    @Test
    public void testForDoubleMove() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        GodCard prova1 = godCardsDeck.createGodCard("artemis");
        assertEquals(prova1.getPowerList().size(),10);

    }
    @Test
    public void testDoubleMoveCorrectness() throws ParserConfigurationException, SAXException, IOException {
        List<Player> playersQueue = new ArrayList<>();
        EventsBuffer eventsBuffer = EventsBuffer.instance();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        playersQueue.add(player1);
        playersQueue.add(player2);
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        GameMaster gameMaster = new GameMaster(playersQueue, 2);
        GodCard godCard1 = godCardsDeck.createGodCard("Artemis");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);

        player1.workersSetup(1, 1, 4, 2);
        player2.workersSetup(4, 4, 4, 3);

        int[] userInput = new int[10];
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        userInput[0] = 1;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
    }
}