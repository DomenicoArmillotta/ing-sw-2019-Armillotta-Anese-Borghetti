package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class TrueGameStartEvent extends ViewEvent {

    ProxyModel proxyModel = ProxyModel.instance();

    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().drawMap();
        proxyModel.getDrawerStrategy().promptPlaceWorkersTest();
        proxyModel.setPhase(2);
    }

}
