package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSwitchSelect extends FindAvailableCellsSelect {
    int num;

    public int doAction(int[] userInput) {

        List<Cell> availableCells;

        super.doAction(userInput);
        availableCells = super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();
        int i, j;
        int tempX = 0;
        int tempY = 0;
        int h = 0;
        boolean addable = false;
        while (availableCells.size() <h) {
            tempX = availableCells.get(h).getX();
            tempY = availableCells.get(h).getY();

            for (i = tempX - 1; i < tempX + 2 && !addable; i++) {
                for (j = tempY + 1; j > tempY - 2 && !addable; j--) {
                    if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                        if (super.executorPointer.getMap()[i][j].getWorkerOnCell() == null || !availableCells.contains(super.executorPointer.getMap()[i][j].getWorkerOnCell())) {
                            if (super.executorPointer.getMap()[i][j].getBuildingLevel().ordinal() - availableCells.get(h).getBuildingLevel().ordinal() <= 1) {
                                addable = true;
                            }
                        }
                    }
                }
            }
            if (addable) {
                super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells().add(availableCells.get(h));
                addable = false;
            }
            h++;
        }
        if(super.loseCheck(super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells())){
            return -1;
        }else
            return 0;
    }
}

