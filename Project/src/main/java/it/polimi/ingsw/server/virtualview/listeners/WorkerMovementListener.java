package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerMovementEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;

public class WorkerMovementListener extends Listener {

    private static WorkerMovementListener instance;

    public static WorkerMovementListener instance() {
        if (instance == null) {
            instance = new WorkerMovementListener();
        }
        return instance;
    }

    public void workerMoved(WorkerMovementEvent workerMovementEvent) {
        eventsBuffer.flushBuffer();
        EventBean eventBean = workerMovementEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        eventsBuffer.setWaiting(false);
        /* send event to clients */
    }

}
