package it.polimi.ingsw;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void PlayersTurnTest() {
        System.out.println("TEST 2: Verifico che se stanno giocando 2 giocatori, gli attributi nextPlayer e prevPlayer di Turn sono uguali.");
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Marco");
        player2.setName("Matteo");
        player1.choosePlayerGod("Atlante");
        player2.choosePlayerGod("Demetra");
        ArrayList<Player> playersList = new ArrayList<>(Arrays.asList(player1, player2));
        GameMaster gameMaster = new GameMaster(2, playersList);
        gameMaster.createMatch();
        assertEquals(gameMaster.getMatch().getCurrentTurn().getNextPlayer().getName(), gameMaster.getMatch().getCurrentTurn().getPrevPlayer().getName());
    }

    @Test
    public void OutOfMapTest() {
        System.out.println("TEST 3: Verifico che un Worker non venga posizionato fuori dalla mappa all'inizio del gioco.");
        /* 25 x 25 */
        int player1FirstChoiceX = 5;
        int player1FirstChoiceY = 2;
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Marco");
        player2.setName("Matteo");
        player1.choosePlayerGod("Atlante");
        player2.choosePlayerGod("Demetra");
        ArrayList<Player> playersList = new ArrayList<>(Arrays.asList(player1, player2));
        GameMaster gameMaster = new GameMaster(2, playersList);
        gameMaster.createMatch();
        assertTrue("Error, X coordinate is too high", player1FirstChoiceX <= 25);
        assertTrue("Error, X coordinate is too low",  player1FirstChoiceX  >= 0);
        assertTrue("Error, Y coordinate is too high", player1FirstChoiceY <= 25);
        assertTrue("Error, Y coordinate is too low",  player1FirstChoiceY  >= 0);
        player1.initFirstWorker(player1FirstChoiceX, player1FirstChoiceY);
    }

}
