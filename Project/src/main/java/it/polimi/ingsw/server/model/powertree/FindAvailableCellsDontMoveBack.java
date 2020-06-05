package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.List;

public class FindAvailableCellsDontMoveBack extends FindAvailableCellsMove {
    @Override
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        Worker selectedWorker;
        selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell toRemoveCell = selectedWorker.getPreviousPosition();
        int i = getWorkerIndex();

        List<Cell> tempCells = super.getExecutorPointer().getNextMove().getAvailableCells(i);

        tempCells.remove(toRemoveCell);

        super.getExecutorPointer().getNextMove().setAvailableCells(tempCells, i);

        //getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextMove().getAvailableCells(i)));

        if(!getExecutorPointer().getCurrentPlayer().getPlayerGod().getMoveLimitationsList().isEmpty())
            executeMoveLimitations();

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextMove().getAvailableCells(i)));
        return 1;
    }
}
