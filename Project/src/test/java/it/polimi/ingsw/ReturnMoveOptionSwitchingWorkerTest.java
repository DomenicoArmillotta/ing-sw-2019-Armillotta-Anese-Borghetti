package it.polimi.ingsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnMoveOptionSwitchingWorkerTest {
    @Test
    public void ReturnTestWorkerSwitch() {
        //inizializzazzione caso dritto creo cella che deve controllare per fare spostamento
        Player n1 = new Player("Marco");
        Player n2 = new Player("Pietro");
        Player n3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(n1);
        playerQueue.add(n2);
        playerQueue.add(n3);
        GameMaster gameMaster1 = new GameMaster(3, playerQueue);
        Match match = new Match(gameMaster1, playerQueue);
        n1.setCurrentMatch(match);
        n2.setCurrentMatch(match);
        match.createMap();
        Cell cella11 = match.getMap()[2][2];
        Cell cella21 = match.getMap()[2][3];
        //Cell cellaDietro = match.getMap()[4][4];
        n1.initFirstWorker(2, 2);
        n2.initFirstWorker(2, 3);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();

        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(God.APOLLO.ordinal()));
        //chiamo funzione
        List<Cell> MoveCells=new ArrayList<>();
        MoveCells=worker11.getOwner().getPlayerGod().getEffect().doReturnFirstMoveOptions(worker11);

        //NELLA CELLA21 ALTRO WORKER NON MIO QUINDI  AGGIUNGE
        //creo lista con celle giuste per la assert
        int i,j,x,y;
        List<Cell> MoveCellsGiuste=new ArrayList<>();
        x=worker11.getCurrentPosition().getX();
        y=worker11.getCurrentPosition().getY();
        Match currentMatch=worker11.getOwner().getCurrentMatch();

        for(i = x - 1; i < x + 2 && i < 5 && i >= 0; i++) {
            for (j = y - 1; j < y + 2 && j < 5 && j >= 0; j++) {
                if(!currentMatch.getMap()[i][j].equals(cella11)){
                    MoveCellsGiuste.add(currentMatch.getMap()[i][j]);
                }

            }
        }

        assertEquals(MoveCellsGiuste,MoveCells);


    }

}