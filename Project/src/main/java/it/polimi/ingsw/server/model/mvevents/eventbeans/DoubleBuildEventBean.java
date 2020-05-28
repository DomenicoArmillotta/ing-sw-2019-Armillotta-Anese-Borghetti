package it.polimi.ingsw.server.model.mvevents.eventbeans;

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
