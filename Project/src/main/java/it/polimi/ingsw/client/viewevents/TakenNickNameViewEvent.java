package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class TakenNickNameViewEvent extends ViewEvent {
    String takenNickName;
    ProxyModel proxyModel = ProxyModel.instance();
    public TakenNickNameViewEvent(String takenNickName) {
        this.takenNickName = takenNickName;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {
        proxyModel.setThisClientNickname("");
    }
}
