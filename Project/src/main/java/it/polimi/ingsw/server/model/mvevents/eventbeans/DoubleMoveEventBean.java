package it.polimi.ingsw.server.model.mvevents.eventbeans;


/**
 *  * create the eventbean that will be sent to the client
 *  * by the server for the message to be displayed in the prompt to ask if it wants move twice
 *  */
public class DoubleMoveEventBean extends EventBean {
    private String  DoubleMethod;

    public DoubleMoveEventBean() {
        DoubleMethod = "do you want to move twice?";
    }

    public String getDoubleMethod() {
        return DoubleMethod;
    }

    public void setDoubleMethod(String doubleMethod) {
        DoubleMethod = doubleMethod;
    }
}
