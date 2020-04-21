package it.polimi.ingsw;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionExecutorTest {
    @Test
    public void singletonActionExecutorTest() {
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
        assertEquals(gameMaster.getActionExecutor(), godCard1.getSelectMoveList().get(0).executorPointer);
        assertEquals(gameMaster.getActionExecutor(), godCard2.getBuildList().get(0).executorPointer);
        assertEquals(gameMaster.getActionExecutor(), godCard3.getFindAvailableCellsList().get(0).executorPointer);
    }

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

    @Test
    public void doActionSwitchSelectTest() {
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

    @Test
    public void doActionMoveTest() {
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
        int[] userInput = new int[10];
        userInput[0] = 3;
        userInput[1] = 2;
        assertEquals(player1.getPlayerGod().getSelectMoveList().get(0).doAction(userInput), 0);
        userInput[0] = 3;
        userInput[1] = 2;
        userInput[2] = 2;
        userInput[3] = 2;
        assertEquals(player1.getPlayerGod().getSelectMoveList().get(1).doAction(userInput), -1);
    }
}