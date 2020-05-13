package it.polimi.ingsw.server.model.mvevents.eventbeans;

import java.io.Serializable;

public class WorkerSelectionEventBean extends EventBean implements Serializable {
    String eventType;
    int workerX;
    int workerY;

    public WorkerSelectionEventBean(int workerX, int workerY){
        eventType = "WorkerSelectionEvent"; /* non qui ma nel parser */
        this.workerX = workerX;
        this.workerY = workerY;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setWorkerX(int workerX) {
        this.workerX = workerX;
    }

    public void setWorkerY(int workerY) {
        this.workerY = workerY;
    }

    public String getEventType() {
        return eventType;
    }

    public int getWorkerX() {
        return workerX;
    }

    public int getWorkerY() {
        return workerY;
    }
}
