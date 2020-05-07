package it.polimi.ingsw.virtualview.listeners;

import it.polimi.ingsw.model.events.WorkerMovementEvent;
import it.polimi.ingsw.model.events.WorkerSelectionEvent;

public class WorkerMovementListener implements Listener {

    private static WorkerMovementListener instance;

    public static WorkerMovementListener instance() {
        if (instance == null) {
            instance = new WorkerMovementListener();
        }
        return instance;
    }

    public void workerMoved(WorkerMovementEvent workerMovementEvent) {
        /* send event to clients */
    }

}
