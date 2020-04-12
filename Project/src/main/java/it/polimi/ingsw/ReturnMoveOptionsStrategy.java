package it.polimi.ingsw;

import java.util.List;

public interface ReturnMoveOptionsStrategy {
    public List<Cell> doReturnMoveOptions(Worker selectedWorker);
}
