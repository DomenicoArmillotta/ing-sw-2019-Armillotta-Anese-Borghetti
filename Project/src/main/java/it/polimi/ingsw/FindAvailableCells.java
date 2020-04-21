package it.polimi.ingsw;

import java.util.List;

public class FindAvailableCells extends Power {
    @Override
    public int doAction(int[] userInput) {
        return 0;
    }

    public boolean loseCheck(List<Cell> availableCells) {
        if (availableCells == null)
            return true;
        return false;
    }
}
