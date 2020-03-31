package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> playersList = new ArrayList<>(Arrays.asList(new Player(), new Player()));
        playersList.get(0).setName("Marco");
        playersList.get(0).choosePlayerGod("Atlante");
        playersList.get(1).setName("Matteo");
        playersList.get(1).choosePlayerGod("Demetra");
        GameMaster gameMaster = new GameMaster(2, playersList);
        gameMaster.createMatch();
    }
}
