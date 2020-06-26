package it.polimi.ingsw.server.model.mvevents.eventbeans;

import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

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
