package it.polimi.ingsw;

public class Cell {
    private Level buildingLevel;
    private Worker workerOnCell;

    public Cell(){}

    public void setWorkerOnCell(Worker workerOnCell) {
        this.workerOnCell = workerOnCell;
    }

    public void setBuildingLevel(Level buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public Worker getWorkerOnCell() {
        return workerOnCell;
    }

    public Level getBuildingLevel() {
        return buildingLevel;
    }}
