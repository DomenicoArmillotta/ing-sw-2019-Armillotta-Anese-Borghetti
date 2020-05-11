package it.polimi.ingsw.servertests.modeltests.powertreetests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcardparser.God;
import it.polimi.ingsw.server.model.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArtemisTest {
    @Test
    public void artemisTest() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(gameMaster.getGodList().get(God.ARTEMIS.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        assertEquals(player1.getPlayerGod().getGodName(), "Artemis");
        assertEquals(player2.getPlayerGod().getGodName(), "Mortal");
        assertEquals(player3.getPlayerGod().getGodName(), "Apollo");

        player1.workersSetup(1, 1, 4, 2);
        player2.workersSetup(4, 4, 4, 3);
        player3.workersSetup(3, 4, 4, 1);

        int[] userInput = new int[10];
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();

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
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);

    }

}