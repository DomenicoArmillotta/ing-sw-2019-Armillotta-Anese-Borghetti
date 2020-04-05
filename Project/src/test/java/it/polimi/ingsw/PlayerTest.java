package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void initWorkerTest() {
        Player n1 = new Player("Marco");
        Player n2 = new Player("Pietro");
        Player n3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(n1);
        playerQueue.add(n2);
        playerQueue.add(n3);
        GameMaster gameMaster1 = new GameMaster(3, playerQueue);
        Match match = new Match(gameMaster1, playerQueue);
        n1.setCurrentMatch(match);
        match.createMap();
        n1.initFirstWorker(3, 4);
        Worker worker1 = n1.getFirstWorker();
        n1.initSecondWorker(4, 4);
        Worker worker2 = n1.getSecondWorker();
        assertEquals(worker1, match.getCell(3, 4).getWorkerOnCell());
        assertEquals(worker2, match.getCell(4, 4).getWorkerOnCell());
        assertEquals(n1, match.getCell(3, 4).getWorkerOnCell().getOwner());
        assertEquals(n1, match.getCell(4, 4).getWorkerOnCell().getOwner());

    }

    @Test
    public void NamePlayerTest() {
        Player n1 = new Player("Marco");
        assertEquals(n1.getName(), "Marco");
    }

    @Test
    public void PlayerGodTest() {
        Player n1 = new Player("Marco");
        GodCard apollo = new GodCard("Apollo", "bla bla");
        n1.setPlayerGod(apollo);
        assertEquals(n1.getPlayerGod(),apollo);
    }
    @Test
    public void PlayerMatchTest(){
        Player n1 = new Player("Marco");
        Player n2 = new Player("Pietro");
        Player n3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(n1);
        playerQueue.add(n2);
        playerQueue.add(n3);
        GameMaster  gameMaster1 = new GameMaster(3,playerQueue);
        Match match=new Match(gameMaster1,playerQueue);
        n1.setCurrentMatch(match);
        assertEquals(n1.getCurrentMatch(),match);
    }

}

