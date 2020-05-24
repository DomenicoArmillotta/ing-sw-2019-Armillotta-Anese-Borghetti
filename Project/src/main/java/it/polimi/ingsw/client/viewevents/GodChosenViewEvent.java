package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.GodCards;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class GodChosenViewEvent extends ViewEvent {
    String chosenGod;
    String player;

    public GodChosenViewEvent(String chosenGod, String player) {
        this.chosenGod = chosenGod;
        this.player = player;
    }

    @Override
    public void viewEventMethod() {
        ProxyModel.instance().getTurn().getCurrentPlayer().setGodCard(new GodCards(chosenGod));
        ProxyModel.instance().getTurn().nextTurn();
        System.out.println(player+" ha scelto correttamente "+chosenGod.toUpperCase());

    }

}
