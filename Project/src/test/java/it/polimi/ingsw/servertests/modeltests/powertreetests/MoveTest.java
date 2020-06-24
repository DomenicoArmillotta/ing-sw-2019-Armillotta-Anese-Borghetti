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

import static org.junit.jupiter.api.Assertions.*;
//funge
public class MoveTest {
    @Test
    public void basicMoveTest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Pan");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Athena");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
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
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);//move basic
        assertEquals(actionExecutor.getMap()[1][0].getWorkerOnCell(), player1.getFirstWorker());
    }

    @Test
    public void wrongMoveCellSelected() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Pan");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Athena");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 2, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        userInput[0] = 4;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);//select

    }
    @Test
    public void lostBecuaseCantMove() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Pan");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Athena");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);//select
        userInput[0] = 1;
        userInput[1] = 0;
    }
}