package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.ClientStatus;
import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PartyLoginViewEvent extends ViewEvent {
    String partyOwner;
    String loggedPlayer;
    public PartyLoginViewEvent(String partyOwner, String loggedPlayer) {
        this.partyOwner = partyOwner;
        this.loggedPlayer = loggedPlayer;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {
        /* ClientStatus.instance().setWhoAmI(loggedPlayer); */
        ClientStatus.instance().setPartyOwner(partyOwner);
    }
}
