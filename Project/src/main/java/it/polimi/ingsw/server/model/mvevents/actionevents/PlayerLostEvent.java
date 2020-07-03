package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.PlayerLostEventBean;

/**
 * event that is generated when a player loses and also has the function of creating his eventbean
 */
public class PlayerLostEvent extends ActionEvent {
    Player loser;

    public PlayerLostEvent(Player loser) {
        this.loser = loser;
    }

    private Player getLoser() {
        return loser;
    }

    public EventBean eventMethod() {
        PlayerLostEventBean playerLostEventBean = new PlayerLostEventBean(getLoser().getName());
        return playerLostEventBean;
    }

}
