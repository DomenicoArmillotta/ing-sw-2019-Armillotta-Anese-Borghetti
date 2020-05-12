package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;

public abstract class ServerEvent {
    abstract public void serverEventMethod(Controller controller);
}
