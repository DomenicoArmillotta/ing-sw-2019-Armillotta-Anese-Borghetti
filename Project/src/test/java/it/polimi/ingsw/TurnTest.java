package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TurnTest {
    @Test
    public void TwoPlayersOrderTest() {
        Player player1 = new Player("Michele");
        Player player2 = new Player("Matteo");
        List<Player> playerQueue = new ArrayList<>();

        playerQueue.add(player1);
        playerQueue.add(player2);

        GameMaster myGameMaster = new GameMaster(2, playerQueue);
        myGameMaster.createMatch();
        Match myMatch = myGameMaster.getMatch();

        Turn myTurn = new Turn(myMatch, playerQueue);

        assertEquals(myTurn.getCurrentPlayer(), player1);
        assertEquals(myTurn.getPrevPlayer(), player2);
        assertEquals(myTurn.getNextPlayer(), player2);

    }

    @Test
    public void ThreePlayersOrderTest() {
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

        Turn myTurn = new Turn(myMatch, playerQueue);

        assertEquals(myTurn.getCurrentPlayer(), player1);
        assertEquals(myTurn.getPrevPlayer(), player3);
        assertEquals(myTurn.getNextPlayer(), player2);

    }

    @Test
    public void CorrectMatchTest() {
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
        player1.setCurrentMatch(myMatch);
        player2.setCurrentMatch(myMatch);
        player3.setCurrentMatch(myMatch);

        Turn myTurn = new Turn(myMatch, playerQueue);

        assertEquals(myTurn.getCurrentPlayer().getCurrentMatch(), player1.getCurrentMatch());
        assertEquals(myTurn.getNextPlayer().getCurrentMatch(), player2.getCurrentMatch());
        assertEquals(myTurn.getPrevPlayer().getCurrentMatch(), player3.getCurrentMatch());


    }

    @Test
    public void NextTurnTest() {
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
        player1.setCurrentMatch(myMatch);
        player2.setCurrentMatch(myMatch);
        player3.setCurrentMatch(myMatch);

        Turn myTurn = new Turn(myMatch, playerQueue);

        myTurn.nextTurn();
        assertEquals(myTurn.getCurrentPlayer(), player2);
        assertEquals(myTurn.getPrevPlayer(), player1);
        assertEquals(myTurn.getNextPlayer(), player3);

        myTurn.nextTurn();
        assertEquals(myTurn.getCurrentPlayer(), player3);
        assertEquals(myTurn.getPrevPlayer(), player2);
        assertEquals(myTurn.getNextPlayer(), player1);

        myTurn.nextTurn();
        assertEquals(myTurn.getCurrentPlayer(), player1);
        assertEquals(myTurn.getPrevPlayer(), player3);
        assertEquals(myTurn.getNextPlayer(), player2);

    }
}
