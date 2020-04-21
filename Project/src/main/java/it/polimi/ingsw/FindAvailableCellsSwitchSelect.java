package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSwitchSelect extends FindAvailableCellsSelect {
    int num;

    public int doAction(int[] userInput) {
        /*la base fa la base e la switch adda le celle*/

        super.doAction(userInput);

        List<Cell> availableCells = super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();

        int i, j;
        int tempX = 0;
        int tempY = 0;
        int h = 0;
        boolean addable = false;
        List<Worker> switchingWorkers = new ArrayList<>();
        List<Cell> tempCells = new ArrayList<>();
        switchingWorkers.add(super.getExecutorPointer().getCurrentActualTurn().getPlayer().getFirstWorker());
        switchingWorkers.add(super.getExecutorPointer().getCurrentActualTurn().getPlayer().getSecondWorker());


        while (h<switchingWorkers.size()) {
            tempX = switchingWorkers.get(h).getCurrentPosition().getX();
            tempY = switchingWorkers.get(h).getCurrentPosition().getY();
            for (i = tempX - 1; i < tempX + 2 && !addable; i++) {
                for (j = tempY + 1; j > tempY - 2 && !addable; j--) {
                    if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                        if (super.getExecutorPointer().getMap()[i][j]!=null && !switchingWorkers.contains(super.getExecutorPointer().getMap()[i][j].getWorkerOnCell())) {
                            if (super.executorPointer.getMap()[i][j].getBuildingLevel().ordinal() - switchingWorkers.get(h).getCurrentPosition().getBuildingLevel().ordinal() <= 1) {
                                addable = true;
                            }
                        }
                    }
                }
            }
            if (addable) {
                tempCells.add(switchingWorkers.get(h).getCurrentPosition());
                addable = false;
            }
            h++;
        }
        super.getExecutorPointer().getCurrentActualTurn().getSelectMoveList().get(0).setAvailableCells(tempCells);
        if (super.loseCheck(super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells())) {
            return -1;
        } else
            return 0;
    }
}

