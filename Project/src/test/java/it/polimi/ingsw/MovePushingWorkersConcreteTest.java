package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class MovePushingWorkersConcreteTest {
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
        match.createMap();
        Cell cella11=new Cell();
        Cell cella21=new Cell();
        Cell cellaDietro=new Cell();
        cella11.setX(3);
       cella11.setY(4);
       cella21.setX(4);
       cella21.setY(4);
       cellaDietro.setX(5);
       cellaDietro.setY(4);
        n1.initFirstWorker(3, 4);
        n2.initFirstWorker(4,4);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();
        cella11.setWorkerOnCell(worker11);
        cella21.setWorkerOnCell(worker21);
        Cell selectedCell=new Cell();
        selectedCell.setY(4);
        selectedCell.setX(4);
        worker11.getOwner().getPlayerGod().getEffect().setEffectStrategies(BasicSelectOptionsConcrete,MovePushingWorkersConcrete,BasicMoveConcrete,BasicWinCheckConcrete,NoSecondMoveConcrete,BasicBuildConcrete);
        //inizializzato tutto con worker con la basicMove e la cella in cui si vuole spostare
        worker11.getOwner().getPlayerGod().getEffect().doMoveWorker(worker11,selectedCell,match.getCurrentTurn());
        assertEquals(worker11.getCurrentPosition(),worker21.getPreviousPosition());
        assertEquals(worker21.getPreviousPosition(),cella21);
        assertEquals(worker21.getCurrentPosition(),cellaDietro);
    }

}