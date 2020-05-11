package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerMovementEvent;

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