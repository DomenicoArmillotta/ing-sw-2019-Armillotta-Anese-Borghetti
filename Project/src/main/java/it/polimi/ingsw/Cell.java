package it.polimi.ingsw;

public class Cell {
    private Level buildingLevel;
    private Worker workerOnCell;

    public Cell(){}

    public void setWorkerOnCell(Worker workerOnCell) {
        this.workerOnCell = workerOnCell;
    }

    public void setBuildinLevel(Level buildinLevel) {
        this.buildingLevel = buildinLevel;
    }

    public Worker getWorkerOnCell() {
        return workerOnCell;
    }

    public int getBuildinLevel() {
        return buildingLevel;
    }}
