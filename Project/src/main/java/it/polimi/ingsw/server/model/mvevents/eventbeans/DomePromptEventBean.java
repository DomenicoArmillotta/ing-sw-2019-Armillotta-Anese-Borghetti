package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create the eventbean that will be sent to the client
 * by the server for the message to be displayed in the prompt to ask if it wants to build a dome
 */
public class DomePromptEventBean extends EventBean{
    private String  DoubleMethod;

    public DomePromptEventBean() {
        DoubleMethod = "do you want to build a dome?";
    }

    public String getDoubleMethod() {
        return DoubleMethod;
    }

    public void setDoubleMethod(String doubleMethod) {
        DoubleMethod = doubleMethod;
    }
}
