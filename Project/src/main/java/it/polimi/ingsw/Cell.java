package it.polimi.ingsw;

public class Cell {
    private int buildingLevel;
    private Worker workerOnCell;

    public Cell(){}

    public void setWorkerOnCell(Worker workerOnCell) {
        this.workerOnCell = workerOnCell;
    }

    public void setBuildinLevel(int buildinLevel) {
        this.buildingLevel = buildinLevel;
    }

    public Worker getWorkerOnCell() {
        return workerOnCell;
    }

    public int getBuildinLevel() {
        return buildingLevel;
    }
}
