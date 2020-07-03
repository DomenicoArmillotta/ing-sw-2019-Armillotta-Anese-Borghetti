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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HephaestusTest {
    @Test
    //non funziona il build
    public void hephaestusTest() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Hephaestus");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        actionExecutor.getMap()[1][1].setBuildingLevel(Level.GROUND); /* try with TOP */


        player1.workersSetup(0, 0, 3, 4);
        player2.workersSetup(4, 3, 4, 1);
        player3.workersSetup(4, 2, 4, 4);

        int[] userInput = new int[10];
        int result;
        //FindAvailableCellsSelectOptions
        actionExecutor.getNextPower().doAction(null);
        //select
        userInput[0] = 0;
        userInput[1] = 0;
        actionExecutor.getNextPower().doAction(userInput);
        //move
        userInput[0] = 0;
        userInput[1] = 1;
        actionExecutor.getNextPower().doAction(userInput);
        //WinCondition
        actionExecutor.getNextPower().doAction(null);
        //FindAvailableCellsBuild
        actionExecutor.getNextPower().doAction(null);
        //build
        userInput[0] = 1;
        userInput[1] = 1;
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getMap()[1][1].getBuildingLevel(),Level.BASE);
        //FindAvailableCellsBuildSameCell
        actionExecutor.getNextPower().doAction(userInput);
        //DoubleBuild
        actionExecutor.getNextPower().doAction(userInput);
        //BuildOnSameCell
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getMap()[1][1].getBuildingLevel(),Level.MID);

    }
}
