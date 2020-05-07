package it.polimi.ingsw.virtualview.listeners;

import it.polimi.ingsw.model.events.NoUpdatesEvent;
import it.polimi.ingsw.model.events.PlayerLostEvent;
import it.polimi.ingsw.model.events.PlayerWonEvent;
import it.polimi.ingsw.model.events.WaitingForActionEvent;

public class NoUpdatesListener implements Listener {

    private static NoUpdatesListener instance;

    public static NoUpdatesListener instance() {
        if (instance == null) {
            instance = new NoUpdatesListener();
        }
        return instance;
    }

    public void noUpdates(NoUpdatesEvent noUpdatesEvent) {
        /* send event to clients */
    }

}
