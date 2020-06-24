package it.polimi.ingsw.servertests.modeltests.powertreetests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
//fail probl 1
public class InstantBuildDomeTest {
    @Test
    public void BuildTest() throws ParserConfigurationException, SAXException, IOException {
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
        GodCard godCard3 = godCardsDeck.createGodCard("Atlante");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        Cell cella11 = map[2][3];
        player1.workersSetup(1, 2, 4, 4);
        player2.workersSetup(4, 2, 4, 1);
        player3.workersSetup(4, 3, 0, 0);
        player1.setPlayerGod(gameMaster.getGodList().get(God.ATLAS.ordinal()));
        int[] a = new int[5];
        actionExecutor.getNextPower().doAction(null);
        //Select
        a[0] = 1;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(a);
        //Move
        a[0] = 2;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(a);
        //WinCondition
        actionExecutor.getNextPower().doAction(null);
        //FindAvailableCellsBuild
        actionExecutor.getNextPower().doAction(null);
        //build
        a[0] = 2;
        a[1] = 3;
        actionExecutor.getNextPower().doAction(a);
        assertEquals(map[2][3].getBuildingLevel(), Level.DOME);
    }

}