package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSelectOptions extends FindAvailableCellsMove {
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(userInput) == 0) {
            Cell firstWorkerCell = getExecutorPointer().getCurrentPlayer().getFirstWorker().getCurrentPosition();
            Cell secondWorkerCell = getExecutorPointer().getCurrentPlayer().getSecondWorker().getCurrentPosition();
            List<Cell> selectOptions = new ArrayList<>();
            if (executorPointer.getNextMove().getAvailableCells(0) != null) {
                selectOptions.add(firstWorkerCell);
            }
            if (executorPointer.getNextMove().getAvailableCells(1) != null) {
                selectOptions.add(secondWorkerCell);
            }

            getWaitingForActionListener().waitForAction(new WaitingForActionEvent(selectOptions));
            return 0;
        } else
            return -1;
    }
}
