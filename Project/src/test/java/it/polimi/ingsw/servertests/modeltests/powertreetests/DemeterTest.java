package it.polimi.ingsw.servertests.modeltests.powertreetests;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
//fail
public class DemeterTest {
    @Test
    public void demeterTest(){
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Demeter");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

        player1.workersSetup(0, 0, 1, 4);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(4, 2, 3, 1);

        int[] userInput = new int[10];
        int result;

        actionExecutor.getNextPower().doAction(null);
        userInput[0] = 0;
        userInput[1] = 0;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0] = 0;
        userInput[1] = 1;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(null);
        userInput[0] = 1;
        userInput[1] = 1;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(null);
        userInput[0] = 1;
        userInput[1] = 0;
        result = actionExecutor.getNextPower().doAction(userInput);
        System.out.println(result);
    }
    @Test
    public void demeterMultiTurnTest(){
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        GodCard godCard1 = godCardsDeck.createGodCard("Demeter");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo");
        GodCard godCard3 = godCardsDeck.createGodCard("Pan");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

        player1.workersSetup(0, 0, 1, 4);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(4, 2, 3, 1);

        int[] userInput = new int[10];
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0] = 0;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        userInput[0] = 0;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);

    }
}
