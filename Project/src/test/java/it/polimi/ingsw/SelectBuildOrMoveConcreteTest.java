package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SelectBuildOrMoveConcreteTest {
    /*
        ci sarà un if case in Selectorbuildmoveconcrete che se il controller passa
        se vuole salire o costrutire.

        dopo questo switch allora if isActive==1 ritorno correttamente il worker e
        cambio la strategy in MoveButDontMoveUp e metto nella move worker ci sarà
        la BasicMoveStrategy + build

        se isActive == 0 allora non cambio strategy ma ritorno easy il worker

        test, 1: voglio muovermi,2:voglio costruire

         */
    @Test
    public void selectWithoutBuilding(){
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
        player1.setPlayerGod(myMatch.getGodList().get(8)); // prometeo
        //creo un dummy worker in 0,0 di player1
        player1.initFirstWorker(0,0);
        Worker w1 = player1.getFirstWorker();
        //creo un turno dummy
        myMatch.startFirstTurn(playerQueue);



    }
}