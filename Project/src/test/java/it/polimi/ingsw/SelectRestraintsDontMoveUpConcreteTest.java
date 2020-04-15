package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class SelectRestraintsDontMoveUpConcreteTest {
    @Test
    public void checkIfRestrainReallyWork(){
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
        player1.setPlayerGod(myMatch.getGodList().get(3)); // atlante
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        assertEquals(player1.getFirstWorker().getCurrentLevel(),Level.GROUND);

        //creo secondo worker dummy

        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.BASE);
        myMatch.getMap()[1][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.DOME);
        myMatch.getMap()[3][4].setBuildingLevel(Level.BASE);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2;
        assertEquals(workersCellsQueue.get(0).getWorkerOnCell(),player1.getFirstWorker());
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        assertEquals(workersCells2.size(),0);
    }
    @Test
    public void lostBecauseRestrainIsActiveWithoutWorkers(){
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
        player1.setPlayerGod(myMatch.getGodList().get(3)); // atlante
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        player1.initSecondWorker(1,1);
        assertEquals(player1.getFirstWorker().getCurrentLevel(),Level.GROUND);
        //creo secondo worker dummy

        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[1][0].setBuildingLevel(Level.BASE);
        myMatch.getMap()[1][2].setBuildingLevel(Level.BASE);
        myMatch.getMap()[0][2].setBuildingLevel(Level.BASE);
        myMatch.getMap()[0][1].setBuildingLevel(Level.BASE);
        myMatch.getMap()[2][1].setBuildingLevel(Level.BASE);
        myMatch.getMap()[2][2].setBuildingLevel(Level.BASE);
        myMatch.getMap()[2][0].setBuildingLevel(Level.BASE);

        //chiamata alla strategy concreta
        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2 = new ArrayList<>();
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        assertEquals(0,workersCells2.size());
    }
    @Test
    public void lostBecauseRestrainIsActiveWithWorkers(){
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
        player2.setCurrentMatch(myMatch);
        player1.setPlayerGod(myMatch.getGodList().get(3)); // atlante
        player2.setPlayerGod(myMatch.getGodList().get(0));//apollo
        //creo un dummy worker in 0,0 di player
        player1.initFirstWorker(0,0);
        //creo worker2 dummy
        myMatch.getMap()[1][1].setBuildingLevel(Level.BASE);
        player2.initFirstWorker(1,1);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.BASE);
        myMatch.getMap()[1][0].setBuildingLevel(Level.DOME);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2 = new ArrayList<>();
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        assertEquals(workersCells2.size(),0);
    }
    @Test
    public void correctlySelectTwoWorkersWhoAreOnTopLevelAndRestrainIsActive(){
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
        player1.setPlayerGod(myMatch.getGodList().get(3)); // atlante
        //creo un dummy worker in 0,0 e 2,2 di player1
        player1.initFirstWorker(0,0);
        player1.initSecondWorker(1,2);
        myMatch.getMap()[0][0].setBuildingLevel(Level.TOP);
        myMatch.getMap()[1][2].setBuildingLevel(Level.TOP);
        player1.getFirstWorker().setCurrentLevel(Level.TOP);
        player1.getSecondWorker().setCurrentLevel(Level.TOP);
        //creo worker2 dummy

        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli


        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2;
        //assertEquals(workersCellsQueue.size(),2);
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        assertEquals(workersCells2.size(),2);
        assertEquals(workersCells2.get(0).getWorkerOnCell(),player1.getFirstWorker());
        assertEquals(workersCells2.get(1).getWorkerOnCell(),player1.getSecondWorker());
        assertEquals(player1.getFirstWorker().getCurrentPosition().getBuildingLevel(),myMatch.getMap()[0][0].getBuildingLevel());
    }

    @Test
    public void lostBecauseRestrainsIsActiveButWithApolloLikeGods(){
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
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        myMatch.getMap()[0][0].setBuildingLevel(Level.GROUND);
        //creo worker2 dummy
        player2.initFirstWorker(1,1);
        myMatch.getMap()[1][1].setBuildingLevel(Level.BASE);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.MID);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2;
        //assertEquals(workersCellsQueue.size(),2);
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        assertEquals(0,workersCells2.size());
        assertEquals(player1.getFirstWorker().getCurrentPosition().getBuildingLevel(),myMatch.getMap()[0][0].getBuildingLevel());
    }
    @Test
    public void canSelectOneWokersOnSameLevelWithIsActiveAndApolloLikeGods(){
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
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        myMatch.getMap()[0][0].setBuildingLevel(Level.BASE);
        player1.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo worker2 dummy
        player2.initFirstWorker(1,1);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        myMatch.getMap()[1][1].setBuildingLevel(Level.BASE);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.MID);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2;
        //assertEquals(workersCellsQueue.size(),2);
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        assertEquals(player1.getFirstWorker(),workersCells2.get(0).getWorkerOnCell());
        assertEquals(workersCells2.size(),1);
        assertEquals(player1.getFirstWorker().getCurrentPosition().getBuildingLevel(),myMatch.getMap()[0][0].getBuildingLevel());
    }
    @Test
    public void lostBecauseRestrainIsActiveWithMinotauroLikeGods(){
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
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);

        //creo worker2 dummy
        player2.initFirstWorker(1,1);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        myMatch.getMap()[1][1].setBuildingLevel(Level.BASE);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.BASE);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2;
        //assertEquals(workersCellsQueue.size(),2);
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        assertEquals(workersCells2.size(),0);
        assertEquals(player1.getFirstWorker().getCurrentPosition().getBuildingLevel(),myMatch.getMap()[0][0].getBuildingLevel());
    }
    @Test
    public void canSelectOneWorkerWithIsActiveAndMinotauroLikeGods(){
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
        player2.setCurrentMatch(myMatch);
        player2.setPlayerGod(myMatch.getGodList().get(1));
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        player1.getFirstWorker().setCurrentLevel(Level.BASE);
        myMatch.getMap()[0][0].setBuildingLevel(Level.BASE);

        //creo worker2 dummy
        player2.initFirstWorker(1,1);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        myMatch.getMap()[1][1].setBuildingLevel(Level.BASE);
        player2.getFirstWorker().setCurrentLevel(Level.BASE);
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        //costruisco gli ostacoli
        myMatch.getMap()[0][1].setBuildingLevel(Level.DOME);
        myMatch.getMap()[1][0].setBuildingLevel(Level.BASE);

        workersCellsQueue = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doReturnSelectOptions(myMatch);
        List<Cell> workersCells2;
        //assertEquals(workersCellsQueue.size(),2);
        workersCells2 = myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSubtractSelectRestraints(workersCellsQueue);
        //assertEquals(workersCells2.get(0).getWorkerOnCell(),player1.getFirstWorker());
        assertEquals(workersCells2.size(),1);
        assertEquals(player1.getFirstWorker().getCurrentPosition().getBuildingLevel(),myMatch.getMap()[0][0].getBuildingLevel());
    }
}
