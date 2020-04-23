package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class Build extends LimitedPower {

    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = getAvailableCells();
        Cell[][] map = getExecutorPointer().getMap();
        //cella su cui voglio costruire
        int blockX = userInput[0];
        int blockY = userInput[1];
        if (availableCells.contains(map[blockX][blockY])) {
            map[blockX][blockY].setBuildingLevel(map[blockX][blockY].getBuildingLevel().getNext());
            return 0;
        }

        return -1;
    }
}
