package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;

public class WaitingForActionViewEvent extends ViewEvent {
    private List<Integer> coordinates;
    private String currTurn;
    ProxyModel proxyModel = ProxyModel.instance();

    public WaitingForActionViewEvent(List<Integer> coordinates,String currTurn) {
        this.coordinates = coordinates;
        this.currTurn = currTurn;
    }

    public void viewEventMethod() {
        proxyModel.getTurn().setCurrentPlayer(new Player(currTurn));
        proxyModel.getDrawerStrategy().setSelectableCell(convertIntoCoords(),1);
        if(proxyModel.getPlayers().size() == 2) proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),null);
        else proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        proxyModel.getDrawerStrategy().setSelectableCell(convertIntoCoords(),0);
    }
    public  List<Coords> convertIntoCoords(){
        List<Coords> coords=new ArrayList<>();
        int l=this.coordinates.size();
        for(int i=0;i<l;i=i+2){
            coords.add(new Coords(this.coordinates.get(i),this.coordinates.get(i+1)));
        }
        return  coords;
    }
}

