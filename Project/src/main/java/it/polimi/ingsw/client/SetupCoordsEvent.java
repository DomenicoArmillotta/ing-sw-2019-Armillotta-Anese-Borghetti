package it.polimi.ingsw.client;

import java.io.Serializable;

public class SetupCoordsEvent extends ClientEvent implements Serializable {
    int x;
    int y;
    int z;
    int w;

    public SetupCoordsEvent(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
}