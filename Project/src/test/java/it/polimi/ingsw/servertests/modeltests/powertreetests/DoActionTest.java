package it.polimi.ingsw.servertests.modeltests.powertreetests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoActionTest {
    @Test
    public void doActionTest() throws ParserConfigurationException, SAXException, IOException {
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
        GodCard godCard3 = godCardsDeck.createGodCard("Mortal");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();

        player1.workersSetup(1, 1, 4, 2);
        player2.workersSetup(4, 4, 4, 3);
        player3.workersSetup(3, 4, 4, 1);

        int[] userInput = new int[10];
        /* map[0][0].setBuildingLevel(Level.BASE);
        map[1][0].setBuildingLevel(Level.BASE);
        map[0][1].setBuildingLevel(Level.BASE);
        map[0][2].setBuildingLevel(Level.BASE);
        map[1][2].setBuildingLevel(Level.BASE);
        map[2][1].setBuildingLevel(Level.BASE);
        map[0][1].setBuildingLevel(Level.BASE); */
        //0 se non deve fare nulla,1 se fa qualcosa in automatico
        //FindAvailableCellsSelectOptions
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        userInput[0] = 1;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 1);
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);



/*
        System.out.println("Next Move: "+actionExecutor.getNextMove());
        System.out.println(actionExecutor.getNextPower());
        userInput[0] = 1;
        userInput[1] = 1;
        System.out.println(actionExecutor.getNextPower());
        userInput[0] = 2;
        userInput[1] = 2;
        System.out.println("Next Move: "+actionExecutor.getNextMove());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println("Next Move: "+actionExecutor.getNextMove());
        userInput[0] = 3;
        userInput[1] = 3;
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        System.out.println(actionExecutor.getNextPower());
        userInput[0] = 2;
        userInput[1] = 3;
        System.out.println(actionExecutor.getNextPower());
*/




/*      player1.workersSetup(1, 1, 4, 0);
        player2.workersSetup(2, 1, 3, 2);
        player3.workersSetup(1, 3, 4, 3); */
/*     actionExecutor.nextTurn();

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 3;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 3;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
*/
    }

}