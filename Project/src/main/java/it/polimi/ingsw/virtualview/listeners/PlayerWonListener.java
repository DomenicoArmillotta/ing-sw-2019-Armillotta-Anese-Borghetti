package it.polimi.ingsw.virtualview.listeners;

import it.polimi.ingsw.model.events.PlayerWonEvent;
import it.polimi.ingsw.model.events.WaitingForActionEvent;

public class PlayerWonListener implements Listener {

    private static PlayerWonListener instance;

    public static PlayerWonListener instance() {
        if (instance == null) {
            instance = new PlayerWonListener();
        }
        return instance;
    }

    public void winGame(PlayerWonEvent playerWonEvent) {
        /* send event to clients */
    }

}
