package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsSwitchMove extends FindAvailableCells {
    int num;

    public int doAction(int[] userInput) {

        List<Cell> availableCells;

        super.doAction(userInput);
        availableCells = super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();
        /* aggiungo le celle con worker avversari */
        if (super.loseCheck(availableCells) == true) {
        }
        super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).setAvailableCells(availableCells);

        return 0;
    }

}
