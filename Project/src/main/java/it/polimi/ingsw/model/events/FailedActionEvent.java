package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.powertree.Power;

public class FailedActionEvent extends Event {

    Power failedPower;

    public FailedActionEvent(Power failedPower) {
        this.failedPower = failedPower;
    }

    public Power getFailedPower() {
        return failedPower;
    }

    public void eventMethod() {
        ;
    }
}
