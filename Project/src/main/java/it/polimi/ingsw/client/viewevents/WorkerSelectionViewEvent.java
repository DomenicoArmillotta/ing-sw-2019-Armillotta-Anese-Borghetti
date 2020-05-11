package it.polimi.ingsw.client.viewevents;

public class WorkerSelectionViewEvent extends ViewEvent {
    int workerX;
    int workerY;

    public WorkerSelectionViewEvent(int workerX, int workerY) {
        this.workerX = workerX;
        this.workerY = workerY;
    }
}
