package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.GodCardParser.God;
import it.polimi.ingsw.virtualview.listeners.WaitingForEventListener;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitingForBuildTest {
    @Test
    public void waitingForBuildTest() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.ARTEMIS.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.DEMETER.ordinal()));
        player1.workersSetup(1, 1, 4, 2);
        player2.workersSetup(4, 4, 4, 3);
        player3.workersSetup(3, 4, 4, 1);
        int[] userInput = new int[10];
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

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
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
    }
}
