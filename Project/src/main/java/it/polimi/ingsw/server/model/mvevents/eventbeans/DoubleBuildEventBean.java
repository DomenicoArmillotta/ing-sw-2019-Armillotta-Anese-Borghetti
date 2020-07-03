package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create the eventbean that will be sent to the client
 * by the server for the message to be displayed in the prompt to ask if it wants build twice
 */
public class DoubleBuildEventBean extends EventBean {
    private String doubleMethod;

    public DoubleBuildEventBean() {
        doubleMethod = "do you want to build twice?";
    }

    public String getDoubleMethod() {
        return doubleMethod;
    }

    public void setDoubleMethod(String doubleMethod) {
        this.doubleMethod = doubleMethod;
    }
}
