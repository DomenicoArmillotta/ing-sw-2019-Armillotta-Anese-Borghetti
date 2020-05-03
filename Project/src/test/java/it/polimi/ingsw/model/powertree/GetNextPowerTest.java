package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.ActionExecutor;
import it.polimi.ingsw.model.GameMaster;
import it.polimi.ingsw.model.GodCardParser.God;
import it.polimi.ingsw.model.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetNextPowerTest {
    @Test
    public void getNextPowerTest() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        assertEquals(player1.getPlayerGod().getGodName(), "Mortal");

        player1.workersSetup(0, 0, 1, 4);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(4, 2, 3, 1);

        int[] userInput = new int[10];
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());

    }
}
