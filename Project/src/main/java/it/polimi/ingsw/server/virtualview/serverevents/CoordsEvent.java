package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;

public class CoordsEvent extends ServerEvent {
    int x;
    int y;
    public CoordsEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CoordsEvent() {
    }

    public void serverEventMethod(Controller controller) {}
}
