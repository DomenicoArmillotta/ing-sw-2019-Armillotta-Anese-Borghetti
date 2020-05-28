package it.polimi.ingsw.server.model.mvevents.eventbeans;


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
