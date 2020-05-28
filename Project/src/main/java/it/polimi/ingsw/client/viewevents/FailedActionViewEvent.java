package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FailedActionViewEvent extends ViewEvent {

    ProxyModel proxyModel = ProxyModel.instance();

    public void viewEventMethod() {
        System.out.println("\u001B[31m"+"["+proxyModel.getTurn().getCurrentPlayer().getName()+"'s action failed]"+"\u001B[0m");
    }
}
