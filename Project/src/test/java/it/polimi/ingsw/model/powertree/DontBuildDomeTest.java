package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DontBuildDomeTest {
    @Test
    public void BuildTestDontDomeReturn() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        Cell[][] map = gameMaster.getActionExecutor().getMap();
        Cell cella11 = map[2][3];
        cella11.setBuildingLevel(Level.TOP);
        player1.workersSetup(1, 2, 4, 4);
        player2.workersSetup(4, 2, 4, 1);
        player3.workersSetup(4, 3, 0, 0);
        player1.setPlayerGod(gameMaster.getGodList().get(God.HEPHAESTUS.ordinal()));
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(a);
        a[0] = 2;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(a);
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(null);
        a[0] = 2;
        a[1] = 3;
        //build

        assertEquals( actionExecutor.getNextPower().doAction(a),-1);
    }

    @Test
    public void BuildTestDontDomeBuild() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        Cell[][] map = gameMaster.getActionExecutor().getMap();
        Cell cella11 = map[2][3];
        player1.workersSetup(1, 2, 4, 4);
        player2.workersSetup(4, 2, 4, 1);
        player3.workersSetup(4, 3, 0, 0);
        player1.setPlayerGod(gameMaster.getGodList().get(God.HEPHAESTUS.ordinal()));
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(a);
        a[0] = 2;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(a);
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(null);
        a[0] = 2;
        a[1] = 3;
        //build
        actionExecutor.getNextPower().doAction(a);
        assertEquals( map[2][3].getBuildingLevel(),Level.BASE);
    }

}