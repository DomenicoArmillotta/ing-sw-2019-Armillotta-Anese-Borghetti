package it.polimi.ingsw.client.viewevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

import java.net.UnknownHostException;

public class CorrectPromptAnswerView extends ViewEvent {
    @Override
    public void viewEventMethod() {
        //System.out.println("In CorrectPromptAnswerView");
        ProxyModel.instance().getDrawerStrategy().drawMap();
    }
}
