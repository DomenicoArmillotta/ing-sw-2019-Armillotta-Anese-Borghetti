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

public class loseConditionCheck {
//fail
    @Test
    public void loseConditionIn3PlayersMatchChangWorkersOrderTest() throws ParserConfigurationException, SAXException, IOException {
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
        GodCard godCard2 = godCardsDeck.createGodCard("Athena");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);

        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
    }

    @Test
    public void loseConditionIn3PlayersMatchDeletingCurrPlayer() throws ParserConfigurationException, SAXException, IOException {
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
        GodCard godCard2 = godCardsDeck.createGodCard("Athena ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        assertEquals(map[0][0].getWorkerOnCell(),null);
        assertEquals(map[4][4].getWorkerOnCell(),null);
        assertEquals(actionExecutor.getCurrentPlayer(),player2);
    }
    @Test
    public void loseConditionIn3PlayersButMatchGoesOn() throws ParserConfigurationException, SAXException, IOException {
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
        GodCard godCard2 = godCardsDeck.createGodCard("Artemis ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 0, 4, 4);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(null), -1);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        assertEquals(map[0][0].getWorkerOnCell(),null);
        assertEquals(map[4][4].getWorkerOnCell(),null);
        assertEquals(actionExecutor.getCurrentPlayer(),player2);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        actionExecutor.getNextPower().doAction(null);//selezione di player 2
        userInput[0] = 0;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        userInput[0] = 0;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);

        actionExecutor.nextTurn();
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getNextPlayer(),actionExecutor.getPrevPlayer());
    }
    @Test
    public void loseConditionIn3PlayersLoseConditionNotFirstPlayer() throws ParserConfigurationException, SAXException, IOException {
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
        GodCard godCard3 = godCardsDeck.createGodCard("Atlas");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][1].setBuildingLevel(Level.TOP);
        map[3][3].setBuildingLevel(Level.TOP);
        map[4][3].setBuildingLevel(Level.TOP);
        map[3][4].setBuildingLevel(Level.TOP);
        player1.workersSetup(0, 2, 2, 1);
        player2.workersSetup(0, 0, 4, 4);
        player3.workersSetup(1, 0, 2, 2);

        int[] userInput = new int[2];

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 0;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 0;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);

        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getCurrentPlayer(),player2);

        assertEquals(actionExecutor.getNextPower().doAction(null),-1);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());
        assertEquals(map[0][0].getWorkerOnCell(),null);
        assertEquals(map[4][4].getWorkerOnCell(),null);
        assertEquals(actionExecutor.getNextPlayer(), actionExecutor.getPrevPlayer());

        actionExecutor.nextTurn();
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getNextPlayer(),actionExecutor.getPrevPlayer());
    }
}

