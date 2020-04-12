package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCheckingLevelConcreteTest {
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
        //fine creazione
        worker1.getOwner().getPlayerGod().getEffect().setEffectStrategies(new BasicReturnSelectOptionsConcrete(), new BasicSelectWorkerConcrete(),
                new BasicReturnBuildOptionsConcrete(), new BasicBuildBlockConcrete(), new BasicReturnMoveOptions(),
                new SubtractRestraintsDontMoveUpConcrete(), new BasicMoveWorkerConcrete(), new BasicReturnMoveOptions(),
                new SubtractRestraintsDontMoveUpConcrete(), new BasicMoveWorkerConcrete(), new BasicReturnBuildOptionsConcrete(),
                new BasicBuildBlockConcrete(), new BasicReturnBuildOptionsConcrete(), new BasicBuildBlockConcrete());
        //inizializzato tutto con worker con la basicMove e la cella in cui si vuole spostare
        worker1.getOwner().getPlayerGod().getEffect().doMoveWorkerFirstTime(worker1, selectedCell);
        //fa la mossa
        assertEquals(worker1.getOwner().getPlayerGod().getEffect().getStatus(), true);
    }
}