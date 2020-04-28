package it.polimi.ingsw.model;

public class Worker {
    private Cell currentPosition;
    private Cell previousPosition;
    private Player owner;

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Worker(Cell currentPosition) {
        this.currentPosition = currentPosition;
        this.previousPosition = currentPosition;
        currentPosition.setWorkerOnCell(this);
    }
    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }
    public void setPreviousPosition(Cell previousPosition) {
        this.previousPosition = previousPosition;
    }
    public Cell getCurrentPosition()
    {
        return currentPosition;
    }
    public Cell getPreviousPosition()
    {
        return previousPosition;
    }
    public void removeWorker(){
        this.currentPosition=null;
        this.previousPosition=null;
        this.owner=null;
    }


}
