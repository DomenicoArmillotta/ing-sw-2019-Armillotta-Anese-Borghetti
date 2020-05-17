package it.polimi.ingsw.server.virtualview.serverevents;


import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CorrectLoginPartyOwnerEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.GenericLoginFailureEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.TakenNickNameEvent;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

public class LoginEvent extends ServerEvent {
    private String payload;

    public LoginEvent(String payload) {
        this.payload = payload;
    }

    @Override
    public void serverEventMethod(Controller controller) {
        int controllerReturn = controller.loginControl(payload);
        /* se uno è party-owner*/
        EventsBuffer eventsBuffer = EventsBuffer.instance();
        if(controllerReturn == 1)
            eventsBuffer.setLastEventBean(new CorrectLoginPartyOwnerEvent(payload));
        else
        if(controllerReturn == 0)
            eventsBuffer.setLastEventBean(new TakenNickNameEvent(payload));
        else
            eventsBuffer.setLastEventBean(new GenericLoginFailureEvent());
    }
}
