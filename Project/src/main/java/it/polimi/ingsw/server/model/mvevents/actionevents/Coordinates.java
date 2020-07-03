package it.polimi.ingsw.server.model.mvevents.actionevents;

/**
 * instead of using cells for describing a position on the board Coordinates  call is more useful and easy to parse
 */

public class Coordinates {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
