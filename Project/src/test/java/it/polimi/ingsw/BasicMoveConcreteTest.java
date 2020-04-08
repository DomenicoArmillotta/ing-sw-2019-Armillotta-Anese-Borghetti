package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BasicMoveConcreteTest {
    @Test
    public void moveWorkerTest() {
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
        Cell selectedCell=new Cell();
        selectedCell.setY(4);
        selectedCell.setX(4);
        worker1.getOwner().getPlayerGod().getEffect().setEffectStrategies(BasicSelectOptionsConcrete,BasicMoveOptionsConcrete,BasicMoveConcrete,BasicWinCheckConcrete,NoSecondMoveConcrete,BasicBuildConcrete);
        //inizializzato tutto con worker con la basicMove e la cella in cui si vuole spostare
        worker1.getOwner().getPlayerGod().getEffect().doMoveWorker(worker1,selectedCell,match.getCurrentTurn());
        assertEquals(worker1.getCurrentPosition(),selectedCell);
    }

}