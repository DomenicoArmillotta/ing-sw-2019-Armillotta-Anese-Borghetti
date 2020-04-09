package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {
    @Test
    public void ConstructorTest() {
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

        assertEquals(myMatch.getGameMaster(), myGameMaster);
        assertEquals(myMatch.getPlayersOrder(), playerQueue);

    }

    @Test
    public void CreateGodListTest() {
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

        myMatch.createGodList();

        assertEquals(myMatch.getGodList().get(0).getGodName(), "Apollo");
        assertEquals(myMatch.getGodList().get(1).getGodName(), "Artemide");
        assertEquals(myMatch.getGodList().get(2).getGodName(), "Athena");
        assertEquals(myMatch.getGodList().get(3).getGodName(), "Atlante");
        assertEquals(myMatch.getGodList().get(4).getGodName(), "Demetra");
        assertEquals(myMatch.getGodList().get(5).getGodName(), "Efesto");
        assertEquals(myMatch.getGodList().get(6).getGodName(), "Minotauro");
        assertEquals(myMatch.getGodList().get(7).getGodName(), "Pan");
        assertEquals(myMatch.getGodList().get(8).getGodName(), "Prometeo");

    }
}
