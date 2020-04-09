package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    public void checkIfMapIsCorrectlyInitializeTest(){
        Player n1 = new Player("Marco");
        Player n2 = new Player("Pietro");
        Player n3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();

        playerQueue.add(n1);
        playerQueue.add(n2);
        playerQueue.add(n3);
        GameMaster  gameMaster1 = new GameMaster(3,playerQueue);
        gameMaster1.createMatch();
        gameMaster1.getMatch().createMap();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals((gameMaster1.getMatch()).getMap()[i][j].getBuildingLevel(),Level.GROUND);

            }
        }
    }
    @Test
    public void correctlySettCellsCoordinatesXeYTest(){
        Player n1 = new Player("Marco");
        Player n2 = new Player("Pietro");
        Player n3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();

        playerQueue.add(n1);
        playerQueue.add(n2);
        playerQueue.add(n3);
        GameMaster  gameMaster1 = new GameMaster(3,playerQueue);
        gameMaster1.createMatch();
        gameMaster1.getMatch().createMap();
        Cell[][] map = gameMaster1.getMatch().getMap();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(map[i][j].getX(),j);
                assertEquals(map[i][j].getY(),i);
            }
        }
    }
}