package it.polimi.ingsw;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnMoveOptionNotPreviousPositionTest {
    @Test
    public void ReturnTestNotPrevious() {
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
        Cell cellaPrecedente = match.getMap()[2][3];
        Worker worker11 = n1.getFirstWorker();
        match.createGodList();
        worker11.getOwner().setPlayerGod(match.getGodList().get(God.ARTEMIDE.ordinal()));
        worker11.setPreviousPosition(cellaPrecedente);
        //chiamo funzione
        List<Cell> MoveCells = new ArrayList();
        MoveCells = worker11.getOwner().getPlayerGod().getEffect().doReturnSecondMoveOptions(worker11);

        //creo lista con celle giuste per la assert
        int i, j, x, y;
        List<Cell> MoveCellsGiuste = new ArrayList();
        x = worker11.getCurrentPosition().getX();
        y = worker11.getCurrentPosition().getY();
        //assertEquals(x,2);
        //assertEquals(y,2);

        Match currentMatch = worker11.getOwner().getCurrentMatch();
        for (i = x - 1; i < x + 2 && i < 5 && i >= 0; i++) {
            for (j = y - 1; j < y + 2 && j < 5 && j >= 0; j++) {
                if (!currentMatch.getMap()[i][j].equals(cella11) && !currentMatch.getMap()[i][j].equals(cellaPrecedente))
                    MoveCellsGiuste.add(currentMatch.getMap()[i][j]);
            }
        }

        assertEquals(MoveCellsGiuste, MoveCells);

    }

}