package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BasicSelectOptionsConcreteTest {
    @Test
    public void correctlyPassedSelectedWorker(){
        //mi aspetto che ciò che torna dal controller sia == a ciò storato nel model
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();

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
        Worker w1 = player1.getFirstWorker();
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);
        assertEquals(w1,player1.getFirstWorker());
        assertEquals(myMatch.getCurrentTurn().getCurrentPlayer().getPlayerGod().getEffect().doSelectOptions(myMatch.getCurrentTurn(),0,0),player1.getFirstWorker());
    }

}