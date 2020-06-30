package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//fail
public class MovePushTest {
    @Test
    public void testMovePush() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Minotaur");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
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
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);//move pushing workers
        assertEquals(actionExecutor.getMap()[2][0].getWorkerOnCell(),player3.getFirstWorker());
    }
    @Test
    public void lostBecausePushIsNotPossible() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Minotaur");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();

        map[1][0].setBuildingLevel(Level.MID);
        map[0][1].setBuildingLevel(Level.MID);
        map[1][1].setBuildingLevel(Level.MID);

        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);//select

    }
    @Test
    public void correctlyPushAWorkerDown() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Minotaur");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();

        map[1][0].setBuildingLevel(Level.MID);
        map[0][1].setBuildingLevel(Level.MID);
        map[1][1].setBuildingLevel(Level.BASE);
        map[2][1].setBuildingLevel((Level.GROUND));

        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 1, 2, 2);
        player3.workersSetup(1, 0, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);//select
        userInput[0]=2;
        userInput[1]=2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);//find cell move
        assertEquals(actionExecutor.getPrevSelect().getSelectedWorker(),player1.getSecondWorker());
        assertEquals(map[3][3].getWorkerOnCell().getOwner(),player2);

    }
}