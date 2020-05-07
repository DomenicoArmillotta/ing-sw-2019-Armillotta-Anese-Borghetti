package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.Worker;
import it.polimi.ingsw.model.powertree.Power;

public class PlayerWonEvent extends Event {
    Player winner;

    public PlayerWonEvent(Player winner) {
        this.winner = winner;
    }

    private Player getWinner() {
        return winner;
    }

    public void eventMethod() {
        ;
    }
}
