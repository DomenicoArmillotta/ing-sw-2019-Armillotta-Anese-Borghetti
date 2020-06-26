package it.polimi.ingsw.client.viewevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.polimi.ingsw.client.proxymodel.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract public class ViewEvent {

    public abstract void viewEventMethod() throws UnknownHostException, JsonProcessingException;

}
