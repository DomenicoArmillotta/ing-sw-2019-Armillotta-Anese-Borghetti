package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    public void checkIfMapIsCorrectlyInitializeTest(){
        Player n1 = new Player();
        Player n2 = new Player();
        Player n3 = new Player();
        List<Player> playerQueue = new ArrayList<>();
        n1.setName("Marco");
        n2.setName("Pietro");
        n3.setName("Domenico");
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
}