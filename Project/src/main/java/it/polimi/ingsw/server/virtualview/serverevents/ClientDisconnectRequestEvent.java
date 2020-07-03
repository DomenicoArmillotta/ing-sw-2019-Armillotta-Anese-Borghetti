package it.polimi.ingsw.server.virtualview.serverevents;
import it.polimi.ingsw.server.controller.Controller;
/**
 * this ClientDisconnectRequestEvent was generated after the parser decoded the message received from the client and ActionExecutor
 * call the controller
 * this BooleanEvent is used for client disconnection
 */
public class ClientDisconnectRequestEvent extends ServerEvent{
    private String socketToDisconnect;

    public ClientDisconnectRequestEvent(String serverToDisconnect){
        this.socketToDisconnect = serverToDisconnect;
    }

    @Override
    public void serverEventMethod(Controller controller) {
        System.out.println("Client Disconnected");
    }
}
