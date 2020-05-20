package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.virtualview.network.VvLobby;

public class StartUpEvent extends ServerEvent {
    private String playerComm;

    public StartUpEvent(String playerComm) {
        this.playerComm = playerComm;
    }

    @Override
    public void serverEventMethod(Controller controller) {
        if(playerComm.equals(VvLobby.instance().getPartyOwner())) {

            controller.startGameControl();
            /*evento di inizio gioco*/

        }
        else{}
            /*

             */
    }
}
