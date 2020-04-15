package it.polimi.ingsw;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BasicReturnMoveOptionsTest {
    @Test
    public void ReturnTestAll() {
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
        n1.initFirstWorker(2, 2);
        Worker worker11 = n1.getFirstWorker();
        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(2));
        //chiamo funzione
        List<Cell> MoveCells=new ArrayList();
        MoveCells=worker11.getOwner().getPlayerGod().getEffect().doReturnFirstMoveOptions(worker11);

        //creo lista con celle giuste per la assert
        int i,j,x,y;
        List<Cell> MoveCellsGiuste=new ArrayList();
        x=worker11.getCurrentPosition().getX();
        y=worker11.getCurrentPosition().getY();
        //assertEquals(x,2);
        //assertEquals(y,2);

        Match currentMatch=worker11.getOwner().getCurrentMatch();
        for(i=x-1;i<x+2 && i<5 && i>0 ;i++) {
            for (j =y-1; j <y+2 && i<5 && i>0; j++) {
                if(!currentMatch.getMap()[i][j].equals(cella11))
                    MoveCellsGiuste.add(currentMatch.getMap()[i][j]);
            }
        }

        assertEquals(MoveCellsGiuste,MoveCells);
        assertEquals(MoveCellsGiuste.size(),8);



    }
    @Test
    public void ReturnTestWorker() {
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
        Cell cella11 = match.getMap()[4][2];
        Cell cella21 = match.getMap()[4][3];
        //Cell cellaDietro = match.getMap()[4][4];
        n1.initFirstWorker(4, 2);
        n2.initFirstWorker(4, 3);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();

        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(2));
        //chiamo funzione
        List<Cell> MoveCells=new ArrayList<>();
        MoveCells=worker11.getOwner().getPlayerGod().getEffect().doReturnFirstMoveOptions(worker11);

        //NELLA CELLA21 ALTRO WORKER WUINDI NON AGGIUNGE
        //creo lista con celle giuste per la assert
        int i,j,x,y;
        List<Cell> MoveCellsGiuste=new ArrayList<>();
        x=worker11.getCurrentPosition().getX();
        y=worker11.getCurrentPosition().getY();
        Match currentMatch=worker11.getOwner().getCurrentMatch();
        for(i=worker11.getCurrentPosition().getX()-1;i<x+1 && i<6;i++) {
            for (j = worker11.getCurrentPosition().getY() - 1; j < y + 2 && j < 6; j++) {
                if(currentMatch.getMap()[i][j]!=cella21){
                    MoveCellsGiuste.add(currentMatch.getMap()[i][j]);
                }

            }
        }

        assertEquals(MoveCellsGiuste,MoveCells);


    }
    @Test
    public void ReturnTestLevel() {
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
        Cell cella11 = match.getMap()[4][2];
        Cell cella21 = match.getMap()[4][3];
        cella21.setBuildingLevel(Level.TOP);
        //Cell cellaDietro = match.getMap()[4][4];
        n1.initFirstWorker(4, 2);
        n2.initFirstWorker(4, 3);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();

        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(2));
        //chiamo funzione
        List<Cell> MoveCells=new ArrayList<>();
        MoveCells=worker11.getOwner().getPlayerGod().getEffect().doReturnFirstMoveOptions(worker11);

        //NELLA CELLA21 LIVELLO TROPPO ALTO QUINDI NON AGGIUNGE
        //creo lista con celle giuste per la assert
        int i,j,x,y;
        List<Cell> MoveCellsGiuste=new ArrayList<>();
        x=worker11.getCurrentPosition().getX();
        y=worker11.getCurrentPosition().getY();
        Match currentMatch=worker11.getOwner().getCurrentMatch();
        for(i=worker11.getCurrentPosition().getX()-1;i<x+1 && i<6;i++) {
            for (j = worker11.getCurrentPosition().getY() - 1; j < y + 2 && j < 6; j++) {
                if(currentMatch.getMap()[i][j]!=cella21){
                    MoveCellsGiuste.add(currentMatch.getMap()[i][j]);
                }

            }
        }

        assertEquals(MoveCellsGiuste,MoveCells);


    }
    @Test
    public void ReturnTestLevelJumpDown() {
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
        Cell cella11 = match.getMap()[4][2];
        cella11.setBuildingLevel(Level.TOP);
        Cell cella21 = match.getMap()[4][3];
        cella21.setBuildingLevel(Level.GROUND);
        //Cell cellaDietro = match.getMap()[4][4];
        n1.initFirstWorker(4, 2);
        n2.initFirstWorker(4, 3);
        Worker worker11 = n1.getFirstWorker();
        Worker worker21 = n2.getFirstWorker();
        worker11.setCurrentLevel(Level.TOP);

        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(2));
        //chiamo funzione
        List<Cell> MoveCells=new ArrayList<>();
        MoveCells=worker11.getOwner().getPlayerGod().getEffect().doReturnFirstMoveOptions(worker11);

        //NELLA CELLA21 LIVELLO BASSO ALTO QUINDI  AGGIUNGE
        //creo lista con celle giuste per la assert
        int i,j,x,y;
        List<Cell> MoveCellsGiuste=new ArrayList<>();
        x=worker11.getCurrentPosition().getX();
        y=worker11.getCurrentPosition().getY();
        Match currentMatch=worker11.getOwner().getCurrentMatch();
        for(i=worker11.getCurrentPosition().getX()-1;i<x+1 && i<6;i++) {
            for (j = worker11.getCurrentPosition().getY() - 1; j < y + 2 && j < 6; j++) {

                    MoveCellsGiuste.add(currentMatch.getMap()[i][j]);


            }
        }

        assertEquals(MoveCellsGiuste,MoveCells);


    }


}