package it.polimi.ingsw;
/*
import it.polimi.ingsw.old.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionBasicSelectTest {
    @Test
    public void doActionBasicSelectTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(3, playerQueue);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        gameMaster.createActionExecutor();
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        player1.workersSetup(3, 2, 1, 2);
        player2.workersSetup(0, 2, 1, 1);
        player3.workersSetup(4, 0, 2, 3);
        assertEquals(player1.getPlayerGod().getFindAvailableCellsList().get(0).doAction(null), 0);
        assertEquals(player1.getFirstWorker().getCurrentPosition(), map[3][2]);
        assertEquals(player1.getSecondWorker().getCurrentPosition(), map[1][2]);
        assertEquals(player1.getFirstWorker(), map[3][2].getWorkerOnCell());
        assertEquals(player1.getSecondWorker(), map[1][2].getWorkerOnCell());
        int[] userInput = new int[2];
        userInput[0] = 3;
        userInput[1] = 2;
        assertEquals(player1.getPlayerGod().getSelectMoveList().get(0).doAction(userInput), 0);
    }
}*/
