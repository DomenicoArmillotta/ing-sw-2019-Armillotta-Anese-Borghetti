package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create the EveryGodChosenEventBean
 */
public class EveryGodChosenEventBean extends EventBean {
    String eventType;

    /**
     * is the constructor of EveryGodChosenEventBean  which is sent
     *  by the server to the client to communicate that all the gods have been chosen by all the players of the game
     */
    public EveryGodChosenEventBean(){
        eventType = "EveryGodChosenEventBean";
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
