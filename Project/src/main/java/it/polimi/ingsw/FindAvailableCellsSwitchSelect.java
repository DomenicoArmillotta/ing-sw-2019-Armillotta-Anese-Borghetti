package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSwitchSelect extends FindAvailableCellsSelect {
    int num;

    public int doAction(int[] userInput) {

        List<Cell> availableCells;
        super.doAction(userInput);
        availableCells = super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();
        if (super.loseCheck(availableCells) == true) {
        }
        super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).setAvailableCells(availableCells);

        return 0;
    }

}
