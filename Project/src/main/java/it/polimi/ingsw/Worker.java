package it.polimi.ingsw;
public class Worker {
    private Player owner;
    private Cell currentPosition;
    private Cell previousPosition;
    private Level currentLevel;
    private Level previousLevel;

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

    public Level getPreviousLevel() {
        return previousLevel;
    }



    private void removeWorker(){
        this.currentPosition=null;
    }


}
