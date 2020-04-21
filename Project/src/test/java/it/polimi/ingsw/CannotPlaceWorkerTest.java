package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CannotPlaceWorkerTest {
    @Test
    public void cannotPlaceWorkerTest() {
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
        player2.workersSetup(0, 2, 1, 2);
        player3.workersSetup(4, 0, 2, 3);
        assertNotEquals(map[4][0].getWorkerOnCell(), player2.getSecondWorker());
    }
}
