package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.Worker;
import it.polimi.ingsw.model.powertree.Power;

public class PlayerLostEvent extends Event {
    Player loser;

    public PlayerLostEvent(Player loser) {
        this.loser = loser;
    }

    private Player getLoser() {
        return loser;
    }

    public void eventMethod() {
        ;
    }
}
