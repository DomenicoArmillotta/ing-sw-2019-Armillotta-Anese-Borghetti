package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.PlayerLostEventBean;

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
