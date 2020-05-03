package it.polimi.ingsw.model;

import it.polimi.ingsw.model.powertree.Power;

public class FailedActionEvent implements Event {

    Power failedPower;

    public FailedActionEvent(Power failedPower) {
        this.failedPower = failedPower;
    }

    public Power getFailedPower() {
        return failedPower;
    }
}
