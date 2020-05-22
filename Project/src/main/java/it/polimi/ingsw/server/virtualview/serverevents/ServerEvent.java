package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class ServerEvent {
    abstract public void serverEventMethod(Controller controller) throws IOException, SAXException, ParserConfigurationException;
}
