package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

public class PartyLoginViewEvent extends ViewEvent {
    String partyOwner;
    String loggedPlayer;
    ProxyModel proxyModel = ProxyModel.instance();

    public PartyLoginViewEvent(String partyOwner, String loggedPlayer) {
        this.partyOwner = partyOwner;
        this.loggedPlayer = loggedPlayer;
    }

    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().createPlayer(loggedPlayer);
        if(ProxyModel.instance().getPartyOwner().equals("")) ProxyModel.instance().setPartyOwner(partyOwner);
    }
}
