package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class FindAvailableCells extends Power {


    public boolean loseCheck(List<Cell> availableCells) {
        if (availableCells == null)
            return true;
        return false;
    }
}
