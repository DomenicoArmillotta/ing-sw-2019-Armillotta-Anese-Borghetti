package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerLostEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.PlayerLostEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoseTestWhenThereAre3PlayersTest{
    @Test
    public void loseTest() throws ParserConfigurationException, SAXException, IOException {
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
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Atlas");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.TOP);
        map[0][1].setBuildingLevel(Level.TOP);
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 0, 3, 3);
        player2.workersSetup(1, 0, 4, 1);
        player3.workersSetup(1, 1, 2, 2);
        /*
        player 1 deve perdere e mandare gli eventi in maniera corretta
         */

        int[] userInput = new int[2];
        userInput[0] = 3;
        userInput[1] = 3;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0] = 4;
        userInput[1] = 4;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0] = 3;
        userInput[1] = 3;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getCurrentPlayer(),player2);

        actionExecutor.nextTurn();
        actionExecutor.nextTurn();

        assertNotEquals(actionExecutor.getPrevSelect(),actionExecutor.getNextPlayer());
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        /*
        qui si perde
         */
        assertEquals(actionExecutor.getNextPlayer(),actionExecutor.getPrevPlayer());
        assertNotNull(eventsBuffer.getLastEventBean());
        assertEquals(actionExecutor.getCurrentPlayer(),player2);
        userInput[0] = 1;
        userInput[1] = 0;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getPrevSelect().getSelectedWorker(),player2.getFirstWorker());


    }

}