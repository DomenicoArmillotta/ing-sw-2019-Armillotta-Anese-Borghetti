package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.virtualview.network.GamePhase;
import it.polimi.ingsw.server.virtualview.network.VvLobby;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class StartUpEvent extends ServerEvent {
    private String playerComm;

    public StartUpEvent(String playerComm) {
        this.playerComm = playerComm;
    }

    @Override
    public void serverEventMethod(Controller controller) throws IOException, SAXException, ParserConfigurationException {
        if(playerComm.equals(VvLobby.instance().getPartyOwner())) {
            controller.startGameControl();
            /*evento di inizio gioco*/

        }
        else{}
            /*

             */
    }
}
