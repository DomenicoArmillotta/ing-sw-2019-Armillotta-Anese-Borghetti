package it.polimi.ingsw;

import java.util.List;

public interface SubtractMoveRestraintsStrategy {
    public List<Cell> doSubtractMoveRestraints(List<Cell> moveOptionsCells, Worker selectedWorker);
}
