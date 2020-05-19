package it.polimi.ingsw.client;

import java.io.Serializable;

public class SetupCoordsEvent extends CoordsEvent implements Serializable {
    public SetupCoordsEvent(int x, int y, String clientID) {
        super(x, y, clientID);
    }
}