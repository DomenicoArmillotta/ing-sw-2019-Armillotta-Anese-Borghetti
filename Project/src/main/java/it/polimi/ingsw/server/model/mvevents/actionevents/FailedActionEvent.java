package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.FailedActionEventBean;
import it.polimi.ingsw.server.model.powertree.Power;

public class FailedActionEvent extends ActionEvent {

    Power failedPower;

    public FailedActionEvent(Power failedPower) {
        this.failedPower = failedPower;
    }

    private Power getFailedPower() {
        return failedPower;
    }

    public EventBean eventMethod() {
        FailedActionEventBean failedActionEventBean = new FailedActionEventBean();
        return failedActionEventBean;
    }
}
