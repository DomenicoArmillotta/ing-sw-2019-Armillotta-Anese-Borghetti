package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MapInitTest {
    @Test
    public void createMapTest() {
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(actionExecutor.getMap()[i][j].getBuildingLevel(), Level.GROUND);
                assertEquals(actionExecutor.getMap()[i][j].getWorkerOnCell(), null);
            }
        }
    }

    @Test
    public void mapInitTest() {
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
        player1.workersSetup(1, 2, 4, 2);
        player2.workersSetup(3, 2, 1, 1);
        player3.workersSetup(4, 0, 2, 3);
        assertEquals(actionExecutor.getMap()[0][0].getWorkerOnCell(), null);
        assertNotEquals(actionExecutor.getMap()[1][2].getWorkerOnCell(), null);
        assertNotEquals(actionExecutor.getMap()[4][2].getWorkerOnCell(), null);
        assertNotEquals(actionExecutor.getMap()[3][2].getWorkerOnCell(), null);
        assertNotEquals(actionExecutor.getMap()[1][1].getWorkerOnCell(), null);
        assertNotEquals(actionExecutor.getMap()[4][2].getWorkerOnCell(), null);
        assertNotEquals(actionExecutor.getMap()[2][3].getWorkerOnCell(), null);
    }
}
