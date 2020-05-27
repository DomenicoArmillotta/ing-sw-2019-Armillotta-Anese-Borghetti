package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PointerBackTest {
    @Test
    public void pointerBackSelectTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();

        gameMaster.createActionExecutor();
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.MINOTAUR.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();

        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(4, 0, 3, 4);
        player3.workersSetup(3, 0, 4, 3);

        int[] userInput = new int[2];
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 0;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 2;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 3;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 4;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 3;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 0;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);

    }

    @Test
    public void pointerBackmoveTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();

        gameMaster.createActionExecutor();
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.MINOTAUR.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();

        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(4, 0, 3, 4);
        player3.workersSetup(3, 0, 4, 3);

        int[] userInput = new int[2];
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 0;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 1;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 3;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 4;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 3;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);

    }

    @Test
    public void infinitePointerBackTest() {

        Scanner testScanner = new Scanner(System.in);
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();

        gameMaster.createActionExecutor();
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.MINOTAUR.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();


        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(4, 0, 3, 4);
        player3.workersSetup(3, 0, 4, 3);

        int[] userInput = new int[2];

        System.out.println(actionExecutor.getNextPower().doAction(userInput));


    }
}