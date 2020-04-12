package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoveSwitchingWorkersConcreteTest {
    @Test
    public void switchWorkerTest() {
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
        n2.setCurrentMatch(match);
        match.createMap();
        n1.initFirstWorker(3, 4);
        n2.initFirstWorker(4, 4);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();
        Cell selectedCell = match.getMap()[4][4];
        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(0));
        //inizializzato tutto con worker con la basicMove e la cella in cui si vuole spostare
        worker11.getOwner().getPlayerGod().getEffect().doMoveWorkerFirstTime(worker11, selectedCell);
        assertEquals(n1.getFirstWorker().getCurrentPosition(), n2.getFirstWorker().getPreviousPosition());
        assertEquals(n2.getFirstWorker().getCurrentPosition(), n1.getFirstWorker().getPreviousPosition());
    }

}