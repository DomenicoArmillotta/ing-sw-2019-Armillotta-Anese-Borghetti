package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.PlayerWonEventBean;

public class PlayerWonEvent extends ActionEvent {
    Player winner;

    public PlayerWonEvent(Player winner) {
        this.winner = winner;
    }

    private Player getWinner() {
        return winner;
    }

    public EventBean eventMethod() {
        PlayerWonEventBean playerWonEventBean = new PlayerWonEventBean(getWinner().getName());
        return playerWonEventBean;
    }
}
