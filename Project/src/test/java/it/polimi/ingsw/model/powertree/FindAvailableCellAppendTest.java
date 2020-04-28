package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FindAvailableCellAppendTest {
    @Test
    public void correctlyAppendFindAvailableCellsDontMoveUp(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.ATHENA.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;


        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);//find cell move
        assertEquals(true, true);
    }
    @Test
    public void dontActivateDontMoveUp() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.ATHENA.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.GROUND);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;


        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell move
        assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 6);
        assertEquals(true, true);
    }
    @Test
    public void testIfremoveMalusEffect(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.ATHENA.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 4, 4, 4); /* modificata posizione firstWorker (Marco) */

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell move
        assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 7);

        actionExecutor.nextTurn();
        actionExecutor.nextTurn();
        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getCurrentPlayer().getName(), player1.getName());
        userInput[0] = 1; /* modificato input (Marco) */
        userInput[1] = 1; /* modificato input (Marco) */
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0); /* aggiunto assert (Marco) */
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);  /* aggiunto assert (Marco) */
        userInput[0] = 1; /* modificato input (Marco) */
        userInput[1] = 2; /* modificato input (Marco) */
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);  /* aggiunto assert (Marco) */
        assertEquals(player3.getPlayerGod().getPowerList().size(), 6);
        assertEquals(player2.getPlayerGod().getPowerList().size(), 6);
    }
    @Test
    public void otherPlayersCantMoveUpDuringTurnAthena(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.ATHENA.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.BASE);
        map[2][2].setBuildingLevel(Level.BASE);
        map[3][4].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);
        //muovo 00 in 10 e attivo athena
        int[] userInput = new int[2];

        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell move
        assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPlayer().getPlayerGod().getPowerList().size(), 7);

        actionExecutor.nextTurn();
        //muovo player 2 da 21 in 22 ma non devo poter fare la mossa
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=1;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=2;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);
        userInput[0]=1;
        userInput[1]=2;
        actionExecutor.getNextPower().doAction(userInput);

        actionExecutor.nextTurn();
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=4;
        userInput[1]=4;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=3;
        userInput[1]=3;
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getCurrentPlayer().getName(),player1.getName());
        userInput[0]=1;
        userInput[1]=0;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=0;
        userInput[1]=0;
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(player3.getPlayerGod().getPowerList().size(),6);
        assertEquals(player2.getPlayerGod().getPowerList().size(),6);
    }
    @Test
    public void playersCantMoveUpDuringMalusAthenaButCanWhenAthenaIsntActive(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.ATHENA.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.BASE);
        map[2][2].setBuildingLevel(Level.BASE);
        map[3][4].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);
        //muovo 00 in 10 e attivo athena
        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//move
        assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPlayer().getPlayerGod().getPowerList().size(), 7);

        actionExecutor.nextTurn();
        //muovo player 2 da 21 in 22 ma non devo poter fare la mossa
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=1;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=2;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);
        userInput[0]=2;
        userInput[1]=3;
        actionExecutor.getNextPower().doAction(userInput);

        actionExecutor.nextTurn();
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=4;
        userInput[1]=4;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=3;
        userInput[1]=4;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);
        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getCurrentPlayer().getName(),player1.getName());
        userInput[0]=1;
        userInput[1]=1;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=0;
        userInput[1]=1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);

        assertEquals(player3.getPlayerGod().getPowerList().size(),6);
        assertEquals(player2.getPlayerGod().getPowerList().size(),6);

        actionExecutor.nextTurn();
        assertEquals(actionExecutor.getCurrentPlayer(),player2);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=1;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=2;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(),6);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(),6);
    }
}