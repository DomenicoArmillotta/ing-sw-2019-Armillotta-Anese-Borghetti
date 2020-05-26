package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class TrueGameStartEvent extends ViewEvent {

    ProxyModel proxyModel = ProxyModel.instance();

    public void viewEventMethod() {
        //ProxyModel.instance().getTurn().nextTurn();
        proxyModel.getDrawerStrategy().setup();
        if(proxyModel.getPlayers().size() == 2) proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),null);
        else proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        //proxyModel.getDrawerStrategy().setSelectableCell(0);
    }

}
