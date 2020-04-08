package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveSwitchingWorkersConcreteTest {
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
        match.createMap();
        n1.initFirstWorker(3, 4);
        n2.initFirstWorker(4,4);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();
        Cell selectedCell=new Cell();
        selectedCell.setY(4);
        selectedCell.setX(4);
        worker11.getOwner().getPlayerGod().getEffect().setEffectStrategies(BasicSelectOptionsConcrete,MoveSwitchingWorkersConcrete,BasicMoveConcrete,BasicWinCheckConcrete,NoSecondMoveConcrete,BasicBuildConcrete);
        //inizializzato tutto con worker con la basicMove e la cella in cui si vuole spostare
        worker11.getOwner().getPlayerGod().getEffect().doMoveWorker(worker11,selectedCell,match.getCurrentTurn());
        assertEquals(n1.getFirstWorker().getCurrentPosition(),n2.getFirstWorker().getPreviousPosition());
        assertEquals(n2.getFirstWorker().getCurrentPosition(),n1.getFirstWorker().getPreviousPosition());
    }

}