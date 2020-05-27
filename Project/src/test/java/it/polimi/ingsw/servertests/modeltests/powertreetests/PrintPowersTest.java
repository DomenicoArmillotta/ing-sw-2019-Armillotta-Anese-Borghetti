package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintPowersTest {
    @Test
    public void printPowerTest() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(gameMaster.getGodList().get(God.DEMETER.ordinal()));
        assertEquals(player1.getPlayerGod().getGodName(), "Demeter");
        assertEquals(player2.getPlayerGod().getGodName(), "Mortal");

        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(0, 2, 3, 1);

        int[] userInput = new int[10];
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
    }
}
