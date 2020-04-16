package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubtractRestraintsDontMoveUpConcreteTest {
    @Test
    public void checkIfSubtractRestrainDontMoveUpWorksWithNoDHActivated(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> feasibleCells;
        List<Cell> fakeMoveCells = new ArrayList<>();


        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(0)); // apollo
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        //creo secondo worker dummy

        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli la lista delle celle da passare scrausa
        fakeMoveCells.add(myMatch.getMap()[0][1]);
        fakeMoveCells.add(myMatch.getMap()[1][1]);
        fakeMoveCells.add(myMatch.getMap()[1][0]);
        //eseguo il test vero e proprio
        feasibleCells = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractFirstRestraints(fakeMoveCells,player1.getFirstWorker());
        assertEquals(3, feasibleCells.size());
    }
    @Test
    public void lostDueToRestrainMoveOptionsNoFoeWorkersNoDomesNoFriendlyWorkers(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> feasibleCells;
        List<Cell> fakeMoveCells = new ArrayList<>();


        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(0)); // apollo
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        //creo secondo worker dummy

        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli la lista delle celle da passare scrausa
        myMatch.getMap()[0][1].setBuildingLevel(Level.MID);
        myMatch.getMap()[1][1].setBuildingLevel(Level.TOP);
        myMatch.getMap()[1][0].setBuildingLevel(Level.BASE);
        fakeMoveCells.add(myMatch.getMap()[0][1]);
        fakeMoveCells.add(myMatch.getMap()[1][1]);
        fakeMoveCells.add(myMatch.getMap()[1][0]);
        //eseguo il test vero e proprio
        feasibleCells = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractFirstRestraints(fakeMoveCells,player1.getFirstWorker());
        assertEquals(feasibleCells,null);
    }
    @Test
    public void lostDueToRestrainMoveOptionsWithFoeWorkersNoDomesNoFriendlyWorkers(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> feasibleCells;
        List<Cell> fakeMoveCells = new ArrayList<>();


        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(0)); // apollo
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.initFirstWorker(1,1);

        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli la lista delle celle da passare scrausa
        myMatch.getMap()[0][1].setBuildingLevel(Level.MID);
        myMatch.getMap()[1][1].setBuildingLevel(Level.BASE);
        myMatch.getMap()[1][0].setBuildingLevel(Level.BASE);
        fakeMoveCells.add(myMatch.getMap()[0][1]);
        fakeMoveCells.add(myMatch.getMap()[1][1]);
        fakeMoveCells.add(myMatch.getMap()[1][0]);
        //eseguo il test vero e proprio
        feasibleCells = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractFirstRestraints(fakeMoveCells,player1.getFirstWorker());
        assertEquals(feasibleCells,null);
        assertEquals(myMatch.getMap()[1][1].getWorkerOnCell().getCurrentLevel(),myMatch.getMap()[1][1].getBuildingLevel());
    }
    @Test
    public void lostDueToRestrainMoveOptionsWithFoeWorkersNoDomesWithFriendlyWorkers(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> feasibleCells;
        List<Cell> fakeMoveCells = new ArrayList<>();


        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(0)); // apollo
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        myMatch.getMap()[0][0].setBuildingLevel(Level.BASE);
        player1.getFirstWorker().setCurrentLevel(Level.BASE);
        player1.initSecondWorker(0,1);
        player1.getSecondWorker().setCurrentLevel(Level.BASE);
        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.initFirstWorker(1,1);

        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli la lista delle celle da passare scrausa
        myMatch.getMap()[0][1].setBuildingLevel(Level.MID);
        myMatch.getMap()[1][1].setBuildingLevel(Level.BASE);
        myMatch.getMap()[1][0].setBuildingLevel(Level.MID);
        fakeMoveCells.add(myMatch.getMap()[0][1]);
        fakeMoveCells.add(myMatch.getMap()[1][1]);
        fakeMoveCells.add(myMatch.getMap()[1][0]);
        //eseguo il test vero e proprio
        feasibleCells = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractFirstRestraints(fakeMoveCells,player1.getFirstWorker());
        assertEquals(feasibleCells.size(),1);
        assertEquals(myMatch.getMap()[1][1].getWorkerOnCell().getCurrentLevel(),myMatch.getMap()[1][1].getBuildingLevel());
        assertEquals(myMatch.getMap()[0][0].getBuildingLevel(),myMatch.getMap()[0][0].getWorkerOnCell().getCurrentLevel());
    }
}