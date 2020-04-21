package it.polimi.ingsw;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionExecutorTest {
    @Test
    public void singletonActionExecutorTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(3, playerQueue);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        gameMaster.createActionExecutor();
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        assertEquals(gameMaster.getActionExecutor(), godCard1.getSelectMoveList().get(0).executorPointer);
        assertEquals(gameMaster.getActionExecutor(), godCard2.getBuildList().get(0).executorPointer);
        assertEquals(gameMaster.getActionExecutor(), godCard3.getFindAvailableCellsList().get(0).executorPointer);
    }
}