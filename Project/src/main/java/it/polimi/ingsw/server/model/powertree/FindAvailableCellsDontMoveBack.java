package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.List;

/**
 * performs the same function as FindAvailableCellsMove,but delete the cell where it was previously,
 * so it cannot go back to where it was before, used for the second move of artemis
 */
public class FindAvailableCellsDontMoveBack extends FindAvailableCellsMove {
    /**
     *  performs the same function as FindAvailableCellsMove,but delete the cell where it was previously,
     *  if the list has no cells then there are no updates
     * @param userInput
     * @return
     */
    @Override
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        Worker selectedWorker;
        selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell toRemoveCell = selectedWorker.getPreviousPosition();
        int i = getWorkerIndex();

        List<Cell> tempCells = super.getExecutorPointer().getNextMove().getAvailableCells(i);

        tempCells.remove(toRemoveCell);

        if(tempCells.isEmpty()){
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1;
        }

        super.getExecutorPointer().getNextMove().setAvailableCells(tempCells, i);

        //getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextMove().getAvailableCells(i)));

        if(!getExecutorPointer().getCurrentPlayer().getPlayerGod().getMoveLimitationsList().isEmpty())
            executeMoveLimitations();

        if (super.getExecutorPointer().getNextMove().getAvailableCells(i).isEmpty()) {
            return 1;/*special return value*/
        }

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextMove().getAvailableCells(i)));
        return 1;
    }
}
