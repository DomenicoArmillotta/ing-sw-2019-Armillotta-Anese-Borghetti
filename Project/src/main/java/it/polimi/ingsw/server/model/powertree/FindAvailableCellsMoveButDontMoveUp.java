package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * performs the same function as FindAvailableCellsMove but checks that the cells are on the same level as the worker
 */
public class FindAvailableCellsMoveButDontMoveUp extends FindAvailableCellsMove {
    /**
     * from the list of find I delete the cells that have a difference in level greater than or equal to 1 from the list
     * @param userInput
     * @return 0 if FindAvailableCellsMovePush its ok,-1 if FindAvailableCellsMovePush failed
     */
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
        if (super.getExecutorPointer().getNextMove().getAvailableCells(0).isEmpty()) { /* correct index 0 */
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY]: FindAvailableCellsMoveButDontMoveUp failed */
        }

        List<Cell> availableCellsDontMoveUp = new ArrayList<>();
        if(super.getExecutorPointer().getNextMove().getAvailableCells(0).size() != 0) {
            availableCellsDontMoveUp.add(getExecutorPointer().getCurrentPlayer().getFirstWorker().getCurrentPosition());
        }
        if(super.getExecutorPointer().getNextMove().getAvailableCells(1).size() != 0) {
            availableCellsDontMoveUp.add(getExecutorPointer().getCurrentPlayer().getSecondWorker().getCurrentPosition());
        }

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(availableCellsDontMoveUp));

        return 0; /* [NOTIFY]: FindAvailableCellsMovePush done */
    }
}
