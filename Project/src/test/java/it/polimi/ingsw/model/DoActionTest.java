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
        /* map[0][0].setBuildingLevel(Level.BASE);
        map[1][0].setBuildingLevel(Level.BASE);
        map[0][1].setBuildingLevel(Level.BASE);
        map[0][2].setBuildingLevel(Level.BASE);
        map[1][2].setBuildingLevel(Level.BASE);
        map[2][1].setBuildingLevel(Level.BASE);
        map[0][1].setBuildingLevel(Level.BASE); */

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        userInput[0] = 1;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);



/*
        System.out.println("Next Move: "+actionExecutor.getNextMove());
        System.out.println(actionExecutor.getNextPower());
        userInput[0] = 1;
        userInput[1] = 1;
        System.out.println(actionExecutor.getNextPower());
        userInput[0] = 2;
        userInput[1] = 2;
        System.out.println("Next Move: "+actionExecutor.getNextMove());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println("Next Move: "+actionExecutor.getNextMove());
        userInput[0] = 3;
        userInput[1] = 3;
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        userInput[0] = 2;
        userInput[1] = 3;
        System.out.println(actionExecutor.getNextPower());
*/




/*      player1.workersSetup(1, 1, 4, 0);
        player2.workersSetup(2, 1, 3, 2);
        player3.workersSetup(1, 3, 4, 3); */
/*     actionExecutor.nextTurn();

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 3;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 3;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
*/
    }

}