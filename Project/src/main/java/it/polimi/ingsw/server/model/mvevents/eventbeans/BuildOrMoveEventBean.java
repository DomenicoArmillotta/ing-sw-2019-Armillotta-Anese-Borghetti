package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create the BuildOrMoveEventBean bean that will be sent from the server to the client
 */
public class BuildOrMoveEventBean extends EventBean{
    private String  doubleMethod;

    /**
     * is the constructor of BuildOrMoveEventBean used for ask if the player want build before move or not
     */
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
