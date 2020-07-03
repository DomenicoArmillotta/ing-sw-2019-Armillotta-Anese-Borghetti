package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FailedActionViewEvent extends ViewEvent {

    ProxyModel proxyModel = ProxyModel.instance();

    /**
     * used for draw the text when the action fail
     */
    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().drawFailedAction();
    }
}
