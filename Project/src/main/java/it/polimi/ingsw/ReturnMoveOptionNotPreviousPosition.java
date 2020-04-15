package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class ReturnMoveOptionNotPreviousPosition implements ReturnMoveOptionsStrategy {
    @Override
    public List<Cell> doReturnMoveOptions(Worker selectedWorker) {
        //ciclo
        int i,j,x,y,check;
        check=1;
        List <Cell> MoveCells=new ArrayList();
        x=selectedWorker.getCurrentPosition().getX();
        y=selectedWorker.getCurrentPosition().getY();
        Match currentMatch=selectedWorker.getOwner().getCurrentMatch();
        for(i=selectedWorker.getCurrentPosition().getX()-1;i<x+1 && i<6;i++)
        {
            for(j=selectedWorker.getCurrentPosition().getY()-1;j<y+2 && j<6;j++)
            {
                //se  c'è un operatore sopra non  aggiungo nella lista
                if(currentMatch.getMap()[i][j].getWorkerOnCell()==null)
                {
                    check=0;
                }
                //se è la mia vecchia posizione non aggiungo
                if(selectedWorker.getPreviousPosition().equals(currentMatch.getMap()[i][j].getWorkerOnCell()))
                {
                    check=0;
                }
                //se  c'è una cupola non  aggiungo nella lista
                if(currentMatch.getMap()[i][j].getBuildingLevel()==Level.DOME && check==1){
                    check=0;

                }
                //se la differenza è maggiore di 1 non aggiungo nella lista
                if((currentMatch.getMap()[i][j].getBuildingLevel().ordinal()-selectedWorker.getCurrentLevel().ordinal())<1 && check==1 ){

                    check=0;

                }
                if(check==1){
                    //inserisce nella lista
                    MoveCells.add(currentMatch.getMap()[i][j]);
                }
            }
        }
        return MoveCells;
    }
}
