package it.polimi.ingsw.client;

import java.io.Serializable;
/**
 * the event is sent to the server by the client,with the information of the coordinates of the two workers
 * who must be positioned on the map
 */
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getW() {
        return w;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setW(int w) {
        this.w = w;
    }
}