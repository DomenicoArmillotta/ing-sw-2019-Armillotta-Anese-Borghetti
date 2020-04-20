package it.polimi.ingsw;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionExecutorTest {
    @Test
    public void FirstTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(3, playerQueue);
        gameMaster.createGodList();
        gameMaster.createActionExecutor();
        assertEquals(gameMaster.getActionExecutor(), null);
        player1.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        GodCard player1Card = player1.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        actionExecutor.setup(1, 2, 3, 2);
        //assertEquals(player1Card.getPowerList().get(0).doAction(null), 0);


    }

}