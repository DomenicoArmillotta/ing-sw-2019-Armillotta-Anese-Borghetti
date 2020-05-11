package it.polimi.ingsw.server.virtualview.serverevents;

public class CoordsEvent extends ServerEvent {
    int x;
    int y;
    public CoordsEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void serverEventMethod() {

    }
}
