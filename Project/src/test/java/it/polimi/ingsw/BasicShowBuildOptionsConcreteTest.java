package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BasicShowBuildOptionsConcreteTest {
    @Test
    public void correctlyPassedSelectedWorker() {
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
        player1.setPlayerGod(myMatch.getGodList().get(0));
        GodCard chosenGod = player1.getPlayerGod();
        player1.initFirstWorker(3, 4);
        Worker worker1 = player1.getFirstWorker();
        List<Cell> buildableCells = chosenGod.getEffect().doReturnFirstBuildOptionsAfterMove(worker1);
        System.out.println(buildableCells.get(0).getX());
        System.out.println(buildableCells.get(0).getY());
    }
}
