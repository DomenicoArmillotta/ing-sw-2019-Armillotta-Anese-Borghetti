package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveCheckingLevelConcreteTest {
    @Test
    public void moveCheckingLevelWorkerTest() {
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
        Cell selectedCell = new Cell();
        selectedCell.setBuildingLevel(Level.BASE);
        selectedCell.setY(4);
        selectedCell.setX(4);
        //creo oggetti delle strategy
        BasicSelectOptionsConcrete basicSelectOptionsConcrete=new BasicSelectOptionsConcrete();
        BasicMoveOptionsConcrete basicMoveOptionsConcrete=new BasicMoveOptionsConcrete();

        //
        MovePushingWorkersConcrete movePushingWorkersConcrete=new MovePushingWorkersConcrete();
        MoveSwitchingWorkersConcrete moveSwitchingWorkersConcrete=new MoveSwitchingWorkersConcrete();
        MoveCheckingLevelConcrete moveCheckingLevelConcrete=new MoveCheckingLevelConcrete();
        BasicMoveConcrete basicMoveConcrete=new BasicMoveConcrete();
        //
        BasicWinCheckConcrete basicWinCheckConcrete=new BasicWinCheckConcrete();
        NoSecondMoveConcrete noSecondMoveConcrete=new NoSecondMoveConcrete();
        BasicBuildConcrete basicBuildConcrete=new BasicBuildConcrete();
        //fine creazione
        worker1.getOwner().getPlayerGod().getEffect().setEffectStrategies(basicSelectOptionsConcrete, basicMoveOptionsConcrete, moveCheckingLevelConcrete, basicWinCheckConcrete, noSecondMoveConcrete, basicBuildConcrete);
        //inizializzato tutto con worker con la basicMove e la cella in cui si vuole spostare
        worker1.getOwner().getPlayerGod().getEffect().doMoveWorker(worker1,selectedCell,match.getCurrentTurn());
        //fa la mossa
        assertTrue(worker1.getOwner().getPlayerGod().getEffect().getStatus());
    }
}