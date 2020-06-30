package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PointerBackTest {
    @Test
    public void pointerBackSelectTest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Pan");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Minotaur");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
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
    public void pointerBackmoveTest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Pan");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Minotaur");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
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
    public void infinitePointerBackTest() throws ParserConfigurationException, SAXException, IOException {

        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Pan");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Minotaur");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();


        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(4, 0, 3, 4);
        player3.workersSetup(3, 0, 4, 3);

        int[] userInput = new int[2];

        System.out.println(actionExecutor.getNextPower().doAction(userInput));


    }
}