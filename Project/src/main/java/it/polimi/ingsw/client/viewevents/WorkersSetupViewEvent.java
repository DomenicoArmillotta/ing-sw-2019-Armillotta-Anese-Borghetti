package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.Coords;
import it.polimi.ingsw.client.proxymodel.Phase;
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
        proxyModel.getTurn().nextTurn();

        int playerIndex = 0;
        for(int i = 0; i < proxyModel.getPlayers().size(); i++) {
            if (proxyModel.getPlayers().get(i).getName().equals(player)) {
                playerIndex = i;
            }
        }

        /* System.out.println("Workers settati da: "+player); */

        proxyModel.createWorker1(proxyModel.getPlayers().get(playerIndex),new Coords(x,y),playerIndex);
        proxyModel.createWorker2(proxyModel.getPlayers().get(playerIndex),new Coords(z,w),playerIndex);
        //proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        proxyModel.getDrawerStrategy().drawMap();


/* attenzione: i player del turn sono diversi dai player del proxy model */
        if(proxyModel.getPlayers().size() == 2) {
            System.out.println("setup case 1");
            if (proxyModel.getPlayers().get(0).getWorker1() != null && proxyModel.getPlayers().get(1).getWorker1() != null) {
                System.out.println("setup case 4");
                proxyModel.getDrawerStrategy().promptSelectionText();
                proxyModel.setPhase(Phase.GAME);
            }
        } else if(proxyModel.getPlayers().get(0).getWorker1() != null && proxyModel.getPlayers().get(1).getWorker1() != null && proxyModel.getPlayers().get(2).getWorker1() != null) {
            System.out.println("setup case 2");
            proxyModel.getDrawerStrategy().promptSelectionText();
            proxyModel.setPhase(Phase.GAME);
        } else {
            System.out.println("setup case 3, size: "+proxyModel.getPlayers().size());
        }

        if(proxyModel.getPhase().ordinal() == Phase.SETUP.ordinal())
            proxyModel.getDrawerStrategy().promptPlaceWorkersTest();

        /* proxyModel.getDrawerStrategy().promptMovementText(); */
    }


}
