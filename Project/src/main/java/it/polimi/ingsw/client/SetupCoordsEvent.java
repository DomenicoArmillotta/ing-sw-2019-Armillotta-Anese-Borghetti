package it.polimi.ingsw.client;

import java.io.Serializable;

public class SetupCoordsEvent extends CoordsEvent implements Serializable {
    int x;
    int y;
    int z;
    int w;

    public SetupCoordsEvent(int x, int y, int z, int w, String clientID) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        super.clientID = clientID;
    }
}