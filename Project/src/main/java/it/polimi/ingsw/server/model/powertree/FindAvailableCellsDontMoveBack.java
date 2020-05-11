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
        int i;

        if (selectedWorker.equals(super.getExecutorPointer().getCurrentPlayer().getFirstWorker()))
            i = 0;
        else
            i = 1;

        List<Cell> tempCells = super.getExecutorPointer().getNextMove().getAvailableCells(i);
        for (int j = 0; j < tempCells.size(); j++) {
            if (tempCells.get(i).equals(toRemoveCell)) {
                tempCells.remove(j);
                break;
            }
        }
        if (tempCells.isEmpty()) {
            /*
            se non si può muovere un altra volta deve finire il turno senza poter costruire,serve una specie di notify che non può
            essere svolta la seconda build;
             */
            return 1;/*valore speciale di ritorno per indicare chenon può fare la seconda move*/
        } else super.getExecutorPointer().getNextMove().setAvailableCells(tempCells, i);

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextBuild().getAvailableCells(i), null));
        return 0;
    }
}
