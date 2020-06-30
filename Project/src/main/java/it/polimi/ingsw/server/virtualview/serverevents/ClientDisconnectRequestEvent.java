package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.client.ClientEvent;
import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ClientDisconnectRequestEvent extends ServerEvent{
    private String socketToDisconnect;

    public ClientDisconnectRequestEvent(String serverToDisconnect){
        this.socketToDisconnect = serverToDisconnect;
    }

    @Override
    public void serverEventMethod(Controller controller) {
        System.out.println("sssss");
    }
}
