package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnSelectOptionsWithWorkersConcreteTest {
    @Test
    public void selectTwoWorkers(){
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
        player1.setPlayerGod(myMatch.getGodList().get(0)); // apollo
        //creo un dummy worker in 0,0 di player1 e worker2 in 4,4
        player1.initFirstWorker(0,0);
        player1.initSecondWorker(4,4);
        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(0));//passo apollo
        player2.initFirstWorker(1,0);
        player2.initSecondWorker(4,3);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.BASE);
        myMatch.getMap()[1][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[3][3].setBuildingLevel(Level.DOME);
        myMatch.getMap()[3][4].setBuildingLevel(Level.BASE);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        assertEquals(2, workersCellsQueue.size());
    }
    @Test
    public void onlyOneWorkerIsSelectableAndOnlyCanSwitchPosition(){
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
        player1.setPlayerGod(myMatch.getGodList().get(0)); // apollo
        //creo un dummy worker in 0,0 di player
        player1.initFirstWorker(0,0);
        //creo secondo worker dummy
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(2));//passo athena(brr)
        myMatch.getMap()[1][0].setBuildingLevel(Level.BASE);//il worker è rialzato di 1
        player2.initFirstWorker(1,0);//switcha solo con questo qui <-
        player2.initSecondWorker(4,3);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli

        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[3][3].setBuildingLevel(Level.DOME);
        myMatch.getMap()[3][4].setBuildingLevel(Level.DOME);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        assertEquals(1, workersCellsQueue.size());
        assertEquals(workersCellsQueue.get(0),player1.getFirstWorker().getCurrentPosition());
    }

}