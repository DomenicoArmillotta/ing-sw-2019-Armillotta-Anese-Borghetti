package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CorrectGodListEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

/**
 * this PartyOwnerGodListEvent was generated after the parser decoded the message received from the client and ActionExecutor
 * call the controller
 * this BooleanEvent is used for gods chosen by the party owner
 */
public class PartyOwnerGodListEvent  extends ServerEvent{
    private String god1;
    private String god2;
    private String god3;

    public PartyOwnerGodListEvent(String god1, String god2, String god3) {
        this.god1 = god1;
        this.god2 = god2;
        this.god3 = god3;
    }

    @Override
    public void serverEventMethod(Controller controller) {
        if(controller.setCurrentGodList(god1,god2,god3)){
            EventsBuffer.instance().setLastEventBean(new CorrectGodListEventBean(god1,god2,god3));
        }else
            System.out.println("non devo crashare");
    }
}
