package it.polimi.ingsw;

import java.util.List;

public class BasicMove extends SelectMove {
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = super.getAvailableCells();

        return 0;
    }
}
