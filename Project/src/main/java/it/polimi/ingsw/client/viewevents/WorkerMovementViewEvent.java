package it.polimi.ingsw.client.viewevents;

public class WorkerMovementViewEvent extends ViewEvent {
    int prevX;
    int prevY;
    int currX;
    int currY;

    public WorkerMovementViewEvent(int prevX, int prevY, int currX, int currY){
        this.prevX = prevX;
        this.prevY = prevY;
        this.currX = currX;
        this.currY = currY;
    }
    public boolean startWaiting() {
        return false;
    }
}
