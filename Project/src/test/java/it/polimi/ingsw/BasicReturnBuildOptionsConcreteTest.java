package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BasicReturnBuildOptionsConcreteTest {
    @Test
    public void returnBuildOptionsTest() {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster1 = new GameMaster(3, playerQueue);
        gameMaster1.createMatch();
        Match match = gameMaster1.getMatch();
        player1.setCurrentMatch(match);
        match.createMap();
        Cell[][] map = match.getMap();
        player1.initFirstWorker(2, 4);
        Worker worker1 = player1.getFirstWorker();
        Cell selectedCell = match.getMap()[4][4];
        match.createGodList();
        worker1.getOwner().setPlayerGod(match.getGodList().get(God.APOLLO.ordinal()));
        List<Cell> buildOptionsCells = new ArrayList<>();
        buildOptionsCells = worker1.getOwner().getPlayerGod().getEffect().doReturnFirstBuildOptionsAfterMove(worker1);
        assertEquals(buildOptionsCells.size(), 5);
        //assertEquals(worker1.getCurrentPosition(), selectedCell);
    }

}