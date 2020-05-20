package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WaitingForActionViewEvent extends ViewEvent {
    private List<Integer> coordinates;
    private String currTurn;

    public WaitingForActionViewEvent(List<Integer> coordinates,String currTurn) {
        this.coordinates = coordinates;
        this.currTurn = currTurn;
    }
    public boolean startWaiting() {
        return true;
    }

    public void viewEventMethod() {
        ProxyModel.instance().getDrawerStrategy().setSelectableCell(convertIntoCoords());
        ProxyModel.instance().getDrawerStrategy().drawMap();

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

