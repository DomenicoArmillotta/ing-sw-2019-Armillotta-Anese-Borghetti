package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcardparser.God;
import it.polimi.ingsw.server.model.godcardparser.GodCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class loseConditionCheck {

    @Test
    public void loseConditionIn3PlayersMatchChangWorkersOrderTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.ATHENA.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
    }

    @Test
    public void loseConditionIn3PlayersMatchDeletingCurrPlayer() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.ATHENA.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        assertEquals(map[0][0].getWorkerOnCell(),null);
        assertEquals(map[4][4].getWorkerOnCell(),null);
        assertEquals(actionExecutor.getCurrentPlayer(),player2);
    }
    @Test
    public void loseConditionIn3PlayersButMatchGoesOn() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.ARTEMIS.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        assertEquals(map[0][0].getWorkerOnCell(),null);
        assertEquals(map[4][4].getWorkerOnCell(),null);
        assertEquals(actionExecutor.getCurrentPlayer(),player2);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        actionExecutor.getNextPower().doAction(null);//selezione di player 2
        userInput[0] = 0;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0] = 0;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);

        actionExecutor.nextTurn();
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getNextPlayer(),actionExecutor.getPrevPlayer());
    }
    @Test
    public void loseConditionIn3PlayersLoseConditionNotFirstPlayer(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.PAN.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 2, 2, 1);
        player2.workersSetup(0, 0, 4, 4);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 0;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 0;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);

        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getCurrentPlayer(),player2);

        assertEquals(actionExecutor.getNextPower().doAction(null),-1);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        assertEquals(map[0][0].getWorkerOnCell(),null);
        assertEquals(map[4][4].getWorkerOnCell(),null);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());

        actionExecutor.nextTurn();
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getNextPlayer(),actionExecutor.getPrevPlayer());
    }
}
