package it.polimi.ingsw.virtualview.listeners;

import it.polimi.ingsw.model.events.FailedActionEvent;

public class FailedActionListener implements Listener {

    private static FailedActionListener instance;

    public static FailedActionListener instance() {
        if (instance == null) {
            instance = new FailedActionListener();
        }
        return instance;
    }

    public void actionFailed(FailedActionEvent failedActionEvent) {
        /* send event to clients */
    }

}
