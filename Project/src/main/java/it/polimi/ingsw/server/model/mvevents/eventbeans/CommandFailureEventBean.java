package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create the CommandFailureEventBean bean that will be sent from the server to the client when a command fail
 */
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

