package it.polimi.ingsw;
public class Worker {
    private Cell currentPosition;
    private Cell previousPosition;

    public Worker( Cell currentPosition) {
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
    private void removeWorker(){
        this.currentPosition=null;
    }


}
