package it.polimi.ingsw;

public interface PossibleSecondMoveStrategy {
    public void possibleSecondMove(Worker selectedWorker, Cell[] selectedCells, Turn turn);
}
