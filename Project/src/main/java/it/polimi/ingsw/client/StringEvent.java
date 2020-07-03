package it.polimi.ingsw.client;

import java.io.Serializable;
/**
 * the event is sent to the server by the client,
 * and contain the payload
 */
public class StringEvent extends ClientEvent implements Serializable {
    String payload;

    StringEvent(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }
}
