package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.GodCardParser.God;
import it.polimi.ingsw.model.GodCardParser.GodCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoveSwitchTest {
    @Test
    public void switchMovetest(){
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
        player1.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();

        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);//find cell move


        assertEquals(actionExecutor.getMap()[0][0].getWorkerOnCell().getOwner(),player3);
        assertEquals(actionExecutor.getMap()[1][0].getWorkerOnCell().getOwner(),player1);
    }

}