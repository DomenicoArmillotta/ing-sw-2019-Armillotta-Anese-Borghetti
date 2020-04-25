package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HephaestusTest {
    @Test
    public void hephaestusTest() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(gameMaster.getGodList().get(God.HEPHAESTUS.ordinal()));
        assertEquals(player1.getPlayerGod().getGodName(), "Hephaestus");
        assertEquals(player2.getPlayerGod().getGodName(), "Mortal");

        player1.workersSetup(0, 0, 1, 4);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(4, 2, 3, 1);

        int[] userInput = new int[10];
        int result;
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

        actionExecutor.getNextPower().doAction(null);
        userInput[0] = 0;
        userInput[1] = 0;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0] = 0;
        userInput[1] = 1;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(null);
        userInput[0] = 1;
        userInput[1] = 1;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getMap()[1][1].setBuildingLevel(Level.MID); /* try with TOP */
        userInput[0] = 1;
        userInput[1] = 1;
        result = actionExecutor.getNextPower().doAction(userInput);
        System.out.println(result);


    }
}
