package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class BuildOrMoveEventBean {
    private String  doubleMethod;

    public BuildOrMoveEventBean() {
        doubleMethod = "do you want to build before move?";
    }

    public String getDoubleMethod() {
        return doubleMethod;
    }

    public void setDoubleMethod(String doubleMethod) {
        this.doubleMethod = doubleMethod;
    }
}
