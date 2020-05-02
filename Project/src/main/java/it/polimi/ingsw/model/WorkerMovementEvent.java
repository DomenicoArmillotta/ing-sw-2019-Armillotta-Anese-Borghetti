package it.polimi.ingsw.model;

public class WorkerMovementEvent implements Event {
    Worker movedWorker;

    public WorkerMovementEvent(Worker movedWorker) {
        this.movedWorker = movedWorker;
    }

    public Worker getSelectedWorker() {
        return movedWorker;
    }
}
