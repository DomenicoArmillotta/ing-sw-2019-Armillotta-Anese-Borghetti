package it.polimi.ingsw.servertests.virtualviewtests;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitingForBuildTest {
    @Test
    public void waitingForBuildTest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Apollo");
        GodCard godCard2 = godCardsDeck.createGodCard("Artemis ");
        GodCard godCard3 = godCardsDeck.createGodCard("Demeter");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        player1.workersSetup(1, 1, 4, 2);
        player2.workersSetup(4, 4, 4, 3);
        player3.workersSetup(3, 4, 4, 1);
        int[] userInput = new int[10];

        /* Associo il Listener al Soggetto che ascolta */
        /* player1.getPlayerGod().getFindAvailableCellsList().get(1).initListenerList();
        WaitingForEventListener waitingListener = new WaitingForEventListener();
        player1.getPlayerGod().getFindAvailableCellsList().get(1).attachListener(waitingListener);
        waitingListener.setSubject(player1.getPlayerGod().getFindAvailableCellsList().get(1)); */

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
    }
}
