package it.polimi.ingsw.server.model.mvevents.eventbeans;

import java.io.Serializable;

/**
 *create WorkerMovementEventBean that will be sent to the client by the server
 */
public class WorkerMovementEventBean extends EventBean implements Serializable {
    String eventType;
    int prevX;
    int prevY;
    int currX;
    int currY;
    /**
     *is the constructor of WorkerMovementEventBean that will be sent to the client by the server to communicate the movement made by the worker,
     *  then send the previous and current coordinates of the server
     */
    public WorkerMovementEventBean(int prevX, int prevY, int currX, int currY){
        eventType = "WorkerMovementEvent";
        this.prevX = prevX;
        this.prevY = prevY;
        this.currX = currX;
        this.currY = currY;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public void setCurrX(int currX) {
        this.currX = currX;
    }

    public void setCurrY(int currY) {
        this.currY = currY;
    }

    public String getEventType() {
        return eventType;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public int getCurrX() {
        return currX;
    }

    public int getCurrY() {
        return currY;
    }
}
