package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class DomePromptEventBean extends EventBean{
    private String  DoubleMethod;

    public DomePromptEventBean() {
        DoubleMethod = "voi costruire subito una cupola?";
    }

    public String getDoubleMethod() {
        return DoubleMethod;
    }

    public void setDoubleMethod(String doubleMethod) {
        DoubleMethod = doubleMethod;
    }
}
