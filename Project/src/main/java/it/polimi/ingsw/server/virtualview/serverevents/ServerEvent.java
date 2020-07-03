package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;

/**
 * this serverEvent was generated after the parser decoded the message received from the client,
 * it has different subclasses based on the type of event you want to create
 */
public abstract class ServerEvent {
    abstract public void serverEventMethod(Controller controller);
}
