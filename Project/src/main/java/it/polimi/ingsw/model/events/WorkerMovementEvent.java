package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.Worker;

public class WorkerMovementEvent extends Event {
    Worker movedWorker;

    public WorkerMovementEvent(Worker movedWorker) {
        this.movedWorker = movedWorker;
    }

    private Worker getSelectedWorker() {
        return movedWorker;
    }

    public void eventMethod() {
        ;
    }
}
