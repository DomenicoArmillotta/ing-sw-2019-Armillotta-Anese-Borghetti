package it.polimi.ingsw;
//DA FINIRE
import java.util.ArrayList;
import java.util.List;

public class ReturnMoveOptionPushingWorker implements ReturnMoveOptionsStrategy {
    //calcola spostamento indicando cosa somare alle cordinate x,y ritorna un array
    public int calcolaSpostamentoX(Worker selectedWorker, Cell selectedCell) {
        Cell cellaWorkerCheSposta = selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare = selectedCell;
        int differenceX = cellaWorkerCheSposta.getX() - cellaWorkerDaSpostare.getX();
        return differenceX;
    }

    public int calcolaSpostamentoY(Worker selectedWorker, Cell selectedCell) {
        Cell cellaWorkerCheSposta=selectedWorker.getCurrentPosition();
        Cell cellaWorkerDaSpostare=selectedCell;
        int differenceY=cellaWorkerCheSposta.getY()-cellaWorkerDaSpostare.getY();
        return differenceY;
    }

    @Override
    public List<Cell> doReturnMoveOptions(Worker selectedWorker) {
        //ciclo
        int i,j,x,y,check;
        int shiftX;
        int shiftY;
        List <Cell> MoveCells=new ArrayList();
        x=selectedWorker.getCurrentPosition().getX();
        y=selectedWorker.getCurrentPosition().getY();
        Match currentMatch=selectedWorker.getOwner().getCurrentMatch();
        for(i = x - 1; i < x + 2 && i < 5; i++)
        {
            for(j = y - 1; j < y + 2 && j < 5; j++)
            {
                check=1;
                if (i < 0) check = 0;
                if (j < 0) check = 0;
                //se  c'è un operatore ed è mio  non  aggiungo nella lista in alternativa lo aggiungo e controllo che nella cella in direzione c'e una cella libera
                if(currentMatch.getMap()[i][j].getWorkerOnCell()!=null && currentMatch.getMap()[i][j].getWorkerOnCell().getOwner()==selectedWorker.getOwner() && check == 1 )
                {
                    check=0;
                }else{
                    shiftX=calcolaSpostamentoX(selectedWorker,currentMatch.getMap()[i][j]);
                    shiftY=calcolaSpostamentoY(selectedWorker,currentMatch.getMap()[i][j]);
                    //se la cella dove si dovrebbe spostare il worker pushato è occupata da un altro worler non aggiungo alla lista delle celle
                    if(currentMatch.getMap()[i-shiftX][j-shiftX].getWorkerOnCell()!=null){
                        check=0;
                    }
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
