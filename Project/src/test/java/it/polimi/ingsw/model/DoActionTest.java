package it.polimi.ingsw.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DoActionTest {
    @Test
    public void doActionTest() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player2.setPlayerGod(gameMaster.getGodList().get(God.DEMETER.ordinal()));
        assertEquals(player1.getPlayerGod().getGodName(), "Mortal");
        assertEquals(player2.getPlayerGod().getGodName(), "Demeter");

        player1.workersSetup(1, 1, 4, 0);
        player2.workersSetup(2, 1, 3, 2);
        player3.workersSetup(1, 3, 4, 3);


        int[] userInput = new int[10];
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[0][0].setBuildingLevel(Level.BASE);
        map[1][0].setBuildingLevel(Level.BASE);
        map[0][1].setBuildingLevel(Level.BASE);
        map[0][2].setBuildingLevel(Level.BASE);
        map[1][2].setBuildingLevel(Level.BASE);
        map[2][2].setBuildingLevel(Level.GROUND);
        map[2][1].setBuildingLevel(Level.BASE);
        map[0][1].setBuildingLevel(Level.BASE);

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 2;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);

        actionExecutor.nextTurn();
       /* userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 0;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 1;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        //assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 2;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 3;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
*/
    }

}