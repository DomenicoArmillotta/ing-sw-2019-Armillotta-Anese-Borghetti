package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CommandFailureEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
/**
 * this GodChoiceEvent was generated after the parser decoded the message received from the client and ActionExecutor
 * call the controller
 * this BooleanEvent is used for the god chose by the player
 */
public class GodChoiceEvent extends ServerEvent {
    String chosenGod;
    String player;

    public GodChoiceEvent(String chosenGod, String player) {
        this.chosenGod = chosenGod;
        this.player = player;
    }

    @Override
    public void serverEventMethod(Controller controller){
        if(!controller.setPlayerGod(chosenGod, player))
            EventsBuffer.instance().setLastEventBean(new CommandFailureEventBean("error"));
        return;
    }
}
