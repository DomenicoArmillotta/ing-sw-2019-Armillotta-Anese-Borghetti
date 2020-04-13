package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnSelectOptionsPushingWorkersConcreteTest {
    @Test
    public void selectOnlyOneWorkerAndItMustPush() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> workersCellsQueue = new ArrayList<>();

        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(6)); // apollo
        //creo un dummy worker in 0,0 di player1 e worker2 in 4,4
        player1.initFirstWorker(0, 0);

        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        myMatch.getMap()[1][1].setBuildingLevel(Level.GROUND);
        player2.initFirstWorker(1, 1);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.DOME);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        assertEquals(1, workersCellsQueue.size());
    }
    @Test
    public void lostBecauseFoeWorkerDHisActive(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> workersCellsQueue = new ArrayList<>();

        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(6)); // apollo
        //creo un dummy worker in 0,0 di player1 e worker2 in 4,4
        player1.initFirstWorker(0, 0);
        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        myMatch.getMap()[1][1].setBuildingLevel(Level.MID);
        player2.initFirstWorker(1, 1);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.DOME);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        assertEquals(0, workersCellsQueue.size());
    }
    @Test
    public void selectOnlyFoeWorkerButDHIsActive(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> workersCellsQueue = new ArrayList<>();

        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(6)); // apollo
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0, 0);
        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        myMatch.getMap()[1][1].setBuildingLevel(Level.MID);
        player2.initFirstWorker(1, 1);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.BASE);
        //attuo la strategy
        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        assertEquals(1, workersCellsQueue.size());
        assertEquals(player1.getPlayerGod().getGodName(),"Minotauro");

    }
    @Test
    public void lostGameBecausePossibleFoeWorkerIsStuckedByDomes(){
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        List<Cell> workersCellsQueue = new ArrayList<>();

        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        GameMaster myGameMaster = new GameMaster(3, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();
        myMatch.createMap();
        myMatch.createGodList();

        player1.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(6)); // apollo
        //creo un dummy worker in 0,0 di player1 e worker2 in 4,4
        player1.initFirstWorker(3,3);
        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        player2.initFirstWorker(4,4);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[4][3].setBuildingLevel(Level.DOME);
        myMatch.getMap()[4][2].setBuildingLevel(Level.DOME);
        myMatch.getMap()[3][2].setBuildingLevel(Level.DOME);
        myMatch.getMap()[3][4].setBuildingLevel(Level.DOME);
        myMatch.getMap()[2][2].setBuildingLevel(Level.DOME);
        myMatch.getMap()[2][3].setBuildingLevel(Level.DOME);
        myMatch.getMap()[2][4].setBuildingLevel(Level.DOME);


        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        assertEquals(0, workersCellsQueue.size());

    }
}