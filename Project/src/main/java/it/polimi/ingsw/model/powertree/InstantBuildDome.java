package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Level;

import java.util.List;
//forzo costruzione cupola dove si può costruire
public class InstantBuildDome extends Build{
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = getAvailableCells();
        Cell[][] map = getExecutorPointer().getMap();
        //cella su cui voglio costruire
        int blockX = userInput[0];
        int blockY = userInput[1];
        if (availableCells.contains(map[blockX][blockY])) {
            map[blockX][blockY].setBuildingLevel(Level.DOME);
            return 0;
        }

        return -1;
    }
}

