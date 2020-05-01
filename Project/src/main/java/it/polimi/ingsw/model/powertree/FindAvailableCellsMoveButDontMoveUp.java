package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;
import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsMoveButDontMoveUp extends FindAvailableCellsMove {

    @Override
    public int doAction(int[] userInput) {
        Cell[][] map = super.getExecutorPointer().getMap();
        List<Cell> possibleMovableCells; /* = super.getExecutorPointer().getNextMove().getAvailableCells(0); */
        List<Cell> toRemoveCells = new ArrayList<>();
        Worker selectedWorker;
        for (int index = 0; index < 2; index++) {
            if (index == 0) selectedWorker = getExecutorPointer().getCurrentPlayer().getFirstWorker();
            else selectedWorker = getExecutorPointer().getCurrentPlayer().getSecondWorker();

            int i, j, x, y, check;

            /* Non devo aggiungere i workers */

            /* super.doAction(userInput); */
            x = selectedWorker.getCurrentPosition().getX();
            y = selectedWorker.getCurrentPosition().getY();

            for (i = x - 1; i < x + 2 && i < 5; i++) {
                for (j = y - 1; j < y + 2 && j < 5; j++) {
                    check = 1;
                    if (i < 0) i = 0;
                    if (j < 0) j = 0;
                    /* Se il livello è piu alto di quello corrente elimino */
                    if ((selectedWorker.getCurrentPosition().getBuildingLevel().ordinal() - map[i][j].getBuildingLevel().ordinal()) < 0 && check == 1) {
                        /* Devo aggiungere a removablecells le celle che hanno dh */
                        toRemoveCells.add(map[i][j]);
                    }

                }
            }
            super.getExecutorPointer().getNextMove().removeCells(toRemoveCells, index);
        }
        if (super.getExecutorPointer().getNextMove().getAvailableCells(0).isEmpty()) {
            return -1; /* [NOTIFY]: FindAvailableCellsMoveButDontMoveUp failed */
        }
        return 0; /* [NOTIFY]: FindAvailableCellsMovePush done */
    }
}
