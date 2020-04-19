package it.polimi.ingsw;
public class Worker {
    private Player owner;
    private Cell currentPosition;
    private Cell previousPosition;
    private Level currentLevel;
    private Level previousLevel;
    //aggiunto GET PREVIOUSPOSITION

    public Worker(Player owner, Cell currentPosition, Level currentLevel) {
        this.owner = owner;
        this.currentPosition = currentPosition;
        this.previousPosition = currentPosition;
        this.currentLevel = currentLevel;
        this.previousLevel = currentLevel;
        currentPosition.setWorkerOnCell(this);
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    public void setCurrentPosition(Cell currentPosition) {

        this.currentPosition = currentPosition;
    }
    public void setCurrentPosition(int x,int y ) {
        currentPosition=(((this.owner).getCurrentMatch()).getCell(x,y));
        this.currentPosition = currentPosition;
    }

    public void setPreviousPosition(Cell previousPosition) {
        this.previousPosition = previousPosition;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setPreviousLevel(Level previousLevel) {
        this.previousLevel = previousLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Player getOwner() {
        return owner;
    }

    public Cell getCurrentPosition()
    {
        return currentPosition;
    }

    public Cell getPreviousPosition()
    {
        return previousPosition;
    }

    public Level getPreviousLevel() {
        return previousLevel;
    }



    private void removeWorker(){
        this.currentPosition=null;
    }


}
