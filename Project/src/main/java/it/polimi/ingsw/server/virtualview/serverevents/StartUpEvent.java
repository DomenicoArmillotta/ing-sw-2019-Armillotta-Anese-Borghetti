package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CommandFailureEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import it.polimi.ingsw.server.virtualview.network.VvLobby;

public class StartUpEvent extends ServerEvent {
    private String playerComm;
    private String playerNum;


    public StartUpEvent(String playerComm,String playerNum) {
        this.playerComm = playerComm;
        this.playerNum = playerNum;
    }

    @Override
    public void serverEventMethod(Controller controller){
        if(playerComm.equals(VvLobby.instance().getPartyOwner())){
            controller.startGameControl(Integer.parseInt(this.playerNum));
        } else
            EventsBuffer.instance().setLastEventBean(new CommandFailureEventBean(playerComm+", you are not the party owner!! you can't start the game"));
    }
}
