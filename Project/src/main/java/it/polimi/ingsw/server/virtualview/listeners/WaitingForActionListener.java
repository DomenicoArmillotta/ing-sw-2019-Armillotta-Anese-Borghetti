package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

public class WaitingForActionListener implements Listener {

    private static WaitingForActionListener instance;

    public static WaitingForActionListener instance() {
        if (instance == null) {
            instance = new WaitingForActionListener();
        }
        return instance;
    }

    public void waitForAction(WaitingForActionEvent waitingForActionEvent) {
        /* send event to clients */
    }

}
