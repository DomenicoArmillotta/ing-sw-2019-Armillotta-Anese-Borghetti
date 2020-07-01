package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/*
next turn setta a null il power pointer quindi non serve settarlo alla next move
 */
public class TurnTest {
    @Test
    public void turnTest(){
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Controller controller = new Controller();
        EventsBuffer eventsBuffer = EventsBuffer.instance();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Atlas");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo");
        GodCard godCard3 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        player1.workersSetup(0, 0, 3, 3);
        player2.workersSetup(1, 0, 4, 1);
        player3.workersSetup(1, 1, 2, 2);
        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;
        assertNull(actionExecutor.getPowerPtr());
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0] = 0;
        userInput[1] = 1;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0] = 0;
        userInput[1] = 0;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower();
        actionExecutor.nextTurn();
        /*
        next turn setta a null il power pointer quindi penso di aver risolto il problema di prima evviva evviva evviva evviva evviva
         */
        assertNull(actionExecutor.getPowerPtr());
    }
}
