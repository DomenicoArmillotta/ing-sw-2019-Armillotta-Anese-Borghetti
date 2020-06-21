package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.ActionExecutor;
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
    public void demeterTest() throws ParserConfigurationException, SAXException, IOException {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        GodCard godCard1 = godCardsDeck.createGodCard("Demeter");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player1.setPlayerGod(godCard2);
        player1.setPlayerGod(godCard3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);

        player1.workersSetup(0, 0, 1, 4);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(4, 2, 3, 1);

        int[] userInput = new int[10];
        int result;
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

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
}
