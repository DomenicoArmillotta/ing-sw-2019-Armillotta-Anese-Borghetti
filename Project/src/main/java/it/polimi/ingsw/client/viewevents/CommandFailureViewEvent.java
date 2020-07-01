package it.polimi.ingsw.client.viewevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

import java.net.UnknownHostException;

public class CommandFailureViewEvent extends ViewEvent{
    private String whatFailed;
    ProxyModel proxyModel = ProxyModel.instance();

    public CommandFailureViewEvent(String whatFailed){
        this.whatFailed = whatFailed;
    }
    @Override
    public void viewEventMethod(){
        proxyModel.getDrawerStrategy().drawCommandFailure(whatFailed);
    }
}
