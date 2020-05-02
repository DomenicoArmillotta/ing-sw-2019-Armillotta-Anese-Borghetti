package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.model.powertree.Power;

public abstract class Listener {
    private Power subject;

    public void update() {
        subject.getState();
    }

    public Power getSubject() {
        return subject;
    }

    public void setSubject(Power subject) {
        this.subject = subject;
    }

}
