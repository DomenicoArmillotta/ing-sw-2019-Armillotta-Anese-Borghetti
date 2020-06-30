package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.GodCardParser;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//funge
public class GetNextPowerTest {
    @Test
    public void getNextPowerTest() throws ParserConfigurationException, SAXException, IOException {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(godCardsDeck.createGodCard("apollo"));
        assertEquals(player1.getPlayerGod().getGodName(), "Apollo");

        player1.workersSetup(0, 0, 1, 4);
        player2.workersSetup(4, 0, 2, 1);
        player3.workersSetup(4, 2, 3, 1);

        int[] userInput = new int[10];
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();

        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());
        System.out.println("");
        System.out.println("NEXT POWER: " + actionExecutor.getNextPower());
        System.out.println("next: " + actionExecutor.getNextSelect());
        System.out.println("next: " + actionExecutor.getNextMove());
        System.out.println("next: " + actionExecutor.getNextBuild());
        System.out.println("prev: " + actionExecutor.getPrevSelect());
        System.out.println("prev: " + actionExecutor.getPrevMove());
        System.out.println("prev: " + actionExecutor.getPrevBuild());

    }
}
