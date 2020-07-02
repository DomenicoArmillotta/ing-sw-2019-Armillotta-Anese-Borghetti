package it.polimi.ingsw.server.model;

/**
 * class that identifies the cell, also  in its attributes has the worker and level on it
 */
public class Cell {
    private Level buildingLevel;
    private Worker workerOnCell;
    private int X;
    private int Y;

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Cell() {
        this.buildingLevel = Level.GROUND;
    }

    public void setWorkerOnCell(Worker workerOnCell) {
        this.workerOnCell = workerOnCell;
        //workerOnCell.setCurrentPosition(this);
    }

    public void setBuildingLevel(Level buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public Worker getWorkerOnCell() {
        return workerOnCell;
    }

    public Level getBuildingLevel() {
        return buildingLevel;
    }


}
