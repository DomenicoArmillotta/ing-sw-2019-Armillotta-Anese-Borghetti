package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.Coords;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class WorkersSetupViewEvent extends ViewEvent {
    int x;
    int y;
    int z;
    int w;
    String player;
    ProxyModel proxyModel = ProxyModel.instance();

    public WorkersSetupViewEvent(int x, int y, int z, int w, String player) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.player = player;
    }

    public void viewEventMethod() {
        int playerIndex = 0;
        for(int i = 0; i < proxyModel.getPlayers().size(); i++) {
            if (proxyModel.getPlayers().get(i).getName().equals(player)) {
                playerIndex = i;
            }
        }
        proxyModel.getDrawerStrategy().createWorker1(proxyModel.getPlayers().get(playerIndex),new Coords(x,y));
        proxyModel.getDrawerStrategy().createWorker2(proxyModel.getPlayers().get(playerIndex),new Coords(z,w));
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
    }


}
