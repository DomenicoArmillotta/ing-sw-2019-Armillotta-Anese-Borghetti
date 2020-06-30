package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.model.mvevents.eventbeans.PlayerLostEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class loseBecauseOfBuild {
    @Test
    public void loseIn3BecauseOfBuild() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        EventsBuffer eventsBuffer = EventsBuffer.instance();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("apollo");
        GodCard godCard2 = godCardsDeck.createGodCard("atlas");
        GodCard godCard3 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.TOP);
        map[0][1].setBuildingLevel(Level.TOP);
        map[1][1].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.DOME);
        map[3][4].setBuildingLevel(Level.DOME);
        player1.workersSetup(3, 3, 2, 3);
        player2.workersSetup(4, 4, 4, 1);
        player3.workersSetup(1, 1, 1, 2);
        /*
        devo perdere costruendo; penso che apollo sia l'unico che possa perdere perchè non ha più da costruire
         */
        int[] userInput = new int[10];

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 3;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 4;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        /*
        qui perdo
         */
        assertEquals(actionExecutor.getPrevPlayer(), actionExecutor.getNextPlayer());
        assertFalse(eventsBuffer.getEndGame());
    }
    @Test
    public void otherPlayerWonDueToLackOfBuildableCells() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        EventsBuffer eventsBuffer = EventsBuffer.instance();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = null;
        godCard1 = godCardsDeck.createGodCard("apollo");
        GodCard godCard2 = godCardsDeck.createGodCard("atlas");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.TOP);
        map[0][1].setBuildingLevel(Level.TOP);
        map[1][1].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.DOME);
        map[3][4].setBuildingLevel(Level.DOME);
        player1.workersSetup(3, 3, 2, 3);
        player2.workersSetup(4, 4, 4, 1);
        /*
        devo perdere costruendo; penso che apollo sia l'unico che possa perdere perchè non ha più da costruire
         */
        int[] userInput = new int[10];

        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0] = 3;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0] = 4;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        eventsBuffer.flushBuffer();
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        /*
        qui perdo
         */
        assertEquals(eventsBuffer.getLastEventBean().getClass(), PlayerLostEventBean.class);
        assertEquals(actionExecutor.getPrevPlayer(),actionExecutor.getNextPlayer());
    }
}
