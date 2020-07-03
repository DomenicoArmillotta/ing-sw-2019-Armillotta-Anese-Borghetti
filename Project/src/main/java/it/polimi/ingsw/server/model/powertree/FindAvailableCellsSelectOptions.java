package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * controls which workers are selectable
 */
public class FindAvailableCellsSelectOptions extends FindAvailableCellsMove {

    /**
     *if the worker AvailableCells (the cells in which they can move) are different from 0 we give the possibility to select it
     * @param userInput user input from the cli or gui
     * @return -1 failed else 0
     */
    @Override
    public int doAction(int[] userInput) {
        int x = super.doAction(userInput);
        if(x==1||x==0) {
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
