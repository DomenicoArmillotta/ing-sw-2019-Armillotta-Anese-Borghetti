package it.polimi.ingsw.server.model.mvevents.eventbeans;


/**
 *create the ConnectionInterruptEventBean bean that will be sent from the server to the client
 * when a player's connection is lost, and notifies everyone with the player's name
 */
public class ConnectionInterruptEventBean extends EventBean {
    public String faultyClient;

    public ConnectionInterruptEventBean(String faultyClient) {
        this.faultyClient = "il giocatore connesso a "+faultyClient+" si + disconnesso";
    }

    public String getFaultyClient() {
        return faultyClient;
    }

    public void setFaultyClient(String faultyClient) {
        this.faultyClient = faultyClient;
    }
}
