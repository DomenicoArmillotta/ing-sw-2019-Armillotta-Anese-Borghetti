package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class MovePushingWorkersConcreteTest {
    @Test
    public void PushingWorkerTest() {
        //inizializzazzione caso dritto creo cella che deve controllare per fare spostamento
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
        Cell cella11 = match.getMap()[4][2];
        Cell cella21 = match.getMap()[4][3];
        Cell cellaDietro = match.getMap()[4][4];
        n1.initFirstWorker(4, 2);
        n2.initFirstWorker(4, 3);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();

        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(6));
        //inizializzato tutto con worker con la basicMove e la cella in cui si vuole spostare
        worker11.getOwner().getPlayerGod().getEffect().doMoveWorkerFirstTime(worker11, cella21);
        assertEquals(worker11.getCurrentPosition(), worker21.getPreviousPosition());
        assertEquals(worker21.getPreviousPosition(), cella21);
        assertEquals(worker21.getCurrentPosition(), cellaDietro);
    }

}