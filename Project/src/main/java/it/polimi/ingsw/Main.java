package it.polimi.ingsw;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Matteo");
        List<Player> playersList = Arrays.asList(player1, player2);
        GameMaster gameMaster = new GameMaster(2, playersList);
        gameMaster.createMatch();
    }
}
