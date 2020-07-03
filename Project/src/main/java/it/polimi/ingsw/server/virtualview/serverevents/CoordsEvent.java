package it.polimi.ingsw.server.virtualview.serverevents;
import it.polimi.ingsw.server.controller.Controller;
/**
 * this CoordsEvent was generated after the parser decoded the message received from the client and ActionExecutor
 * call the controller
 */
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
