package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

public class PartyLoginViewEvent extends ViewEvent {
    String partyOwner;
    String loggedPlayer;
    ProxyModel proxyModel = ProxyModel.instance();

    /**
     * is the constructor
     * @param partyOwner
     * @param loggedPlayer
     */
    public PartyLoginViewEvent(String partyOwner, String loggedPlayer) {
        this.partyOwner = partyOwner;
        this.loggedPlayer = loggedPlayer;
    }

    /**
     * who is partyOwner is shown (that is who created the room) and shows the indications to start a game
     * add the player that enter in the room to proxyModel
     * show who has just entered with the name
     */
    public void viewEventMethod() {
        proxyModel.addPlayer(loggedPlayer);
        if(ProxyModel.instance().getPartyOwner().equals("")) ProxyModel.instance().setPartyOwner(partyOwner);
        if(loggedPlayer.equals(partyOwner)) {
            System.out.println("\u001B[36m"+loggedPlayer+"\u001B[0m"+" created a new room.");
            System.out.println("When everyone is ready, "+"\u001B[36m"+loggedPlayer+"\u001B[0m"+" should type "+"\u001B[33m"+"start"+"\u001B[0m"+" followed by the number of players ("+"\u001B[33m"+"2"+"\u001B[0m"+" or "+"\u001B[33m"+"3"+"\u001B[0m"+").");
        } else {
            System.out.println("\u001B[36m"+loggedPlayer+"\u001B[0m"+" has just entered "+"\u001B[36m"+partyOwner+"\u001B[0m"+"'s room.");
        }
    }
}
