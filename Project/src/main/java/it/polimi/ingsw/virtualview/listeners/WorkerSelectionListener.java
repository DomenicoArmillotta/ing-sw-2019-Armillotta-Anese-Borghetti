package it.polimi.ingsw.virtualview.listeners;

import it.polimi.ingsw.model.events.WorkerSelectionEvent;

public class WorkerSelectionListener implements Listener {

    private static WorkerSelectionListener instance;

    public static WorkerSelectionListener instance() {
        if (instance == null) {
            instance = new WorkerSelectionListener();
        }
        return instance;
    }

    public void workerSelected(WorkerSelectionEvent workerSelectionEvent) {
        /* send event to clients */
    }

}
