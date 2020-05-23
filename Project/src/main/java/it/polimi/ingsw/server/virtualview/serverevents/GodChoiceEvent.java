package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class GodChoiceEvent extends ServerEvent {
    String chosenGod;
    String player;

    public GodChoiceEvent(String chosenGod, String player) {
        this.chosenGod = chosenGod;
        this.player = player;
    }

    @Override
    public void serverEventMethod(Controller controller) throws IOException, SAXException, ParserConfigurationException {
        controller.setPlayerGod(chosenGod, player);
    }
}
