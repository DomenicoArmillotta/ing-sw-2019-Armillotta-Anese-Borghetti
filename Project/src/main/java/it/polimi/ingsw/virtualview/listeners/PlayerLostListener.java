package it.polimi.ingsw.virtualview.listeners;

import it.polimi.ingsw.model.events.PlayerLostEvent;
import it.polimi.ingsw.model.events.PlayerWonEvent;
import it.polimi.ingsw.model.events.WaitingForActionEvent;

public class PlayerLostListener implements Listener {

    private static PlayerLostListener instance;

    public static PlayerLostListener instance() {
        if (instance == null) {
            instance = new PlayerLostListener();
        }
        return instance;
    }

    public void loseGame(PlayerLostEvent playerLostEvent) {
        /* send event to clients */
    }

}
