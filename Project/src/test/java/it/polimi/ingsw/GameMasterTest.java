package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameMasterTest {
    @Test
    public void createPlayerQueueInGameMasterTest(){
        Player n1 = new Player();
        Player n2 = new Player();
        Player n3 = new Player();
        List<Player> playerQueue = new ArrayList<>();
        n1.setName("Marco");
        n2.setName("Pietro");
        n3.setName("Domenico");
        playerQueue.add(n1);
        playerQueue.add(n2);
        playerQueue.add(n3);
        GameMaster  gameMaster1 = new GameMaster(3,playerQueue);
        assertEquals(playerQueue,gameMaster1.getPlayerQueue());
    }



}