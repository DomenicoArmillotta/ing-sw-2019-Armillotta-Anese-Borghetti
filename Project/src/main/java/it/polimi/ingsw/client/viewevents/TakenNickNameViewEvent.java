package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

/**
 * is the view event for taken nick name
 */
public class TakenNickNameViewEvent extends ViewEvent {
    String takenNickName;
    ProxyModel proxyModel = ProxyModel.instance();
    public TakenNickNameViewEvent(String takenNickName) {
        this.takenNickName = takenNickName;
    }

    /**
     * show a message if the name is already taken
     */
    public void viewEventMethod() {
        System.out.println("questo nome è gia stato scelto, perfavore inserirne un altro");
    }
}
