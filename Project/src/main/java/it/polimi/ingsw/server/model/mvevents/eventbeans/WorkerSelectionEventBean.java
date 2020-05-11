package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class WorkerSelectionEventBean extends EventBean {
    String eventType;
    int workerX;
    int workerY;

    public WorkerSelectionEventBean(int workerX, int workerY){
        eventType = "WorkerSelectionEvent";
        this.workerX = workerX;
        this.workerY = workerY;
    }
}
