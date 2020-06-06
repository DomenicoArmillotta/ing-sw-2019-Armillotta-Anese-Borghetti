package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class TrueGameStartEvent extends ViewEvent {

    ProxyModel proxyModel = ProxyModel.instance();

    public void viewEventMethod() {
        //ProxyModel.instance().getTurn().nextTurn();
        //proxyModel.createMap();
        proxyModel.getDrawerStrategy().drawMap();
        //proxyModel.getDrawerStrategy().setSelectableCell(0);
         System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " should place his 2 workers typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed by the desired "+"\u001B[33m" + "4 coordinates" + "\u001B[0m"+".");

        proxyModel.setPhase(2);
    }

}
