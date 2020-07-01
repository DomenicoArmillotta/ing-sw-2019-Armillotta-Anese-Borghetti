package it.polimi.ingsw.servertests.modeltests.powertreetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ArtemisTest {
    @Test
    public void artemisTest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Artemis");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Minotaur");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        player1.workersSetup(0, 0, 4, 2);
        player2.workersSetup(4, 4, 4, 3);
        player3.workersSetup(3, 4, 4, 1);
        int[] userInput = new int[10];

        actionExecutor.getMap()[1][2].setBuildingLevel(Level.GROUND);

        //FindAvailableCellsSelectOptions
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        //select
        userInput[0] =0;
        userInput[1] =0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        //move
        userInput[0] = 0;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        //wincondition
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        //FindAvailableCellDontMoveBack
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        //DoubleMove
        userInput[0] = 0;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        //MoveButDontGoBack
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        //WinCondition
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        //FindAvailableCellsBuild
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        //Build
        userInput[0] = 1;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getMap()[1][2].getBuildingLevel(), Level.BASE);


    }

}