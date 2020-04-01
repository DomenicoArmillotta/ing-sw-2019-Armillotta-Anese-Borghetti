package it.polimi.ingsw;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Marco");
        player2.setName("Matteo");
        player1.choosePlayerGod("Atlante");
        player2.choosePlayerGod("Demetra");
        List<Player> playersList = Arrays.asList(player1, player2);
        GameMaster gameMaster = new GameMaster(2, playersList);
        gameMaster.createMatch();
    }
}
