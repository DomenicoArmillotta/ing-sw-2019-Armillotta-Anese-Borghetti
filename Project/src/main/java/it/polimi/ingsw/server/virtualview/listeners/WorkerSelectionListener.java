package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerSelectionEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * when in the server workerSelectionEvent is triggered,
 * the corresponding eventBean is created, it is inserted in the buffer which will subsequently be sent
 */
public class WorkerSelectionListener extends Listener {

    private static WorkerSelectionListener instance;

    public static WorkerSelectionListener instance() {
        if (instance == null) {
            instance = new WorkerSelectionListener();
        }
        return instance;
    }

    public void workerSelected(WorkerSelectionEvent workerSelectionEvent) {
        EventBean eventBean = workerSelectionEvent.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        /* send event to clients */
    }

}
