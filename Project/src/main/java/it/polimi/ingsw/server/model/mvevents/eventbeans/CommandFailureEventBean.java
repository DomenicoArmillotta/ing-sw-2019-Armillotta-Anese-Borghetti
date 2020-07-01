package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class CommandFailureEventBean extends EventBean{
    private String whatFailed;

    public CommandFailureEventBean(String whatFailed) {
        this.whatFailed = whatFailed;
    }

    public String getWhatFailed() {
        return whatFailed;
    }

    public void setWhatFailed(String whatFailed) {
        this.whatFailed = whatFailed;
    }
}

