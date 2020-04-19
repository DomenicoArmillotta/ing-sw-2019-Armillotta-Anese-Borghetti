package it.polimi.ingsw;
//da sistemare x e Y ATTENZIONE
public class Cell {
    private Level buildingLevel;
    private Level previousLevel;
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
    }

    public void setBuildingLevel(Level buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public void setPreviousLevel(Level previousLevel) {
        this.previousLevel = previousLevel;
    }

    public Worker getWorkerOnCell() {
        return workerOnCell;
    }

    public Level getBuildingLevel() {
        return buildingLevel;
    }

    public Level getPreviousLevel() {
        return previousLevel;
    }

}
