package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class WorkerMovementEventBean extends EventBean {
    String eventType;
    int prevX;
    int prevY;
    int currX;
    int currY;

    public WorkerMovementEventBean(int prevX, int prevY, int currX, int currY){
        eventType = "WorkerMovementEvent";
        this.prevX = prevX;
        this.prevY = prevY;
        this.currX = currX;
        this.currY = currY;
    }
}
