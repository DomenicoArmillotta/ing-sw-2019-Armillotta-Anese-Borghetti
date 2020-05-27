package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionBasicSelectTest {
    @Test
    public void doActionBasicSelectTest() {
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

        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(0, 2, 3, 1);

        assertEquals(player1.getPlayerGod().getFindAvailableCellsList().get(0).doAction(null), 0);
        assertEquals(player1.getFirstWorker().getCurrentPosition(), gameMaster.getActionExecutor().getMap()[0][0]);
        assertEquals(player1.getSecondWorker().getCurrentPosition(), gameMaster.getActionExecutor().getMap()[1][1]);
        assertEquals(player1.getFirstWorker(), gameMaster.getActionExecutor().getMap()[0][0].getWorkerOnCell());
        assertEquals(player1.getSecondWorker(), gameMaster.getActionExecutor().getMap()[1][1].getWorkerOnCell());
        /*int[] userInput = new int[2];
        userInput[0] = 3;
        userInput[1] = 2;
        assertEquals(player1.getPlayerGod().getSelectList().get(0).doAction(userInput), 0);*/
    }
}
