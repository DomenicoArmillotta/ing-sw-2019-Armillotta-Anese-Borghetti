package it.polimi.ingsw.server.virtualview.listeners;

import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerLostEvent;

public class PlayerLostListener extends Listener {

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
