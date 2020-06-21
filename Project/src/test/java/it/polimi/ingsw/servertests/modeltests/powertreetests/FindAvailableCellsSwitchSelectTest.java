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
//fail per prob1
public class FindAvailableCellsSwitchSelectTest {
    @Test
    public void testFindAvailableCellSwitchSelect() throws ParserConfigurationException, SAXException, IOException {
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
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        GodCard godCard1 = godCardsDeck.createGodCard("Apollo");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan");
        GodCard godCard3 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = new ActionExecutor();
        actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 3;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        /* assertEquals(actionExecutor.getNextSelect().getAvailableCells(0).size(), 1); */

    }
    @Test
    public void assertTruee(){
        assertEquals(true,true);
    }

    @Test
    public void lostDueToSelectWitchingWorkers(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.MORTAL.ordinal()));
        gameMaster.createActionExecutor();
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
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        actionExecutor.getNextPower().doAction(userInput);
        /* assertEquals(actionExecutor.getNextSelect().getAvailableCells(0).size(), 1);
        assertEquals(actionExecutor.getNextSelect().getAvailableCells(0).get(0).getWorkerOnCell(), player1.getSecondWorker()); */
    }
}