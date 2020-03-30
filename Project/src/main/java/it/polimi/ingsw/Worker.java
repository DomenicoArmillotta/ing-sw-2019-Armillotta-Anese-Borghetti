package it.polimi.ingsw;
public class Worker {
    private Player owner;
    private Cell currentPosition;
    private Cell previousPosition;
    private Level currentLevel;
    private Level previousLevel;

    public Worker(Player owner, Cell currentPosition, Cell previousPosition, Level currentLevel, Level previousLevel) {
        this.owner = owner;
        this.currentPosition = currentPosition;
        this.previousPosition = previousPosition;
        this.currentLevel = currentLevel;
        this.previousLevel = previousLevel;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setPreviousLevel(Level previousLevel) {
        this.previousLevel = previousLevel;
    }

    public Player getOwner() {
        return owner;
    }



    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public Level getPreviousLevel() {
        return previousLevel;
    }



    private void removeWorker(void){}


}
