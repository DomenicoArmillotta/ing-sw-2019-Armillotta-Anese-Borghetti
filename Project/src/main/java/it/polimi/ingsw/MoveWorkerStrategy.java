package it.polimi.ingsw;

public interface MoveWorkerStrategy {
    public void moveWorker(Worker selectedWorker, Cell[] selectedCells, Turn turn);
}
