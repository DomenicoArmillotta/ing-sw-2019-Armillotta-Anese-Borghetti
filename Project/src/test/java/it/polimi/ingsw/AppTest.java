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
    public void LoginTest() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Marco");
        player2.setName("Matteo");
        player1.choosePlayerGod("Atlante");
        player2.choosePlayerGod("Demetra");
        ArrayList<Player> playersList = new ArrayList<>(Arrays.asList(player1, player2));
        GameMaster gameMaster = new GameMaster(2, playersList);
        gameMaster.createMatch();
        assertEquals("Marco", gameMaster.getMatch().getCurrentTurn().getCurrentPlayer().getName());
    }

}
