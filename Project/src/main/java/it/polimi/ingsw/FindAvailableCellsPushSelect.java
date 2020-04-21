package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.List;
public class FindAvailableCellsPushSelect extends FindAvailableCellsSelect {
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
    int num;

    public int doAction(int[] userInput) {

        List<Cell> availableCells;
        int check,i,j,x,y;
        int shiftX;
        int shiftY;
        //come
        x=selectedWorker.getCurrentPosition().getX();
        y=selectedWorker.getCurrentPosition().getY();
        super.doAction(userInput);
        /* mi vegnono passate le celle con sopra i worker da controllare*/
        availableCells = super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();
        for (i = x - 1; i < x + 2 && i < 5; i++) {
            for (j = y - 1; j < y + 2 && j < 5; j++) {
                check = 1;
                if (i < 0) i = 0;
                if (j < 0) j = 0;

                //se  c'è un operatore ed è mio  non  aggiungo nella lista in alternativa lo aggiungo e controllo che nella cella in direzione c'e una cella libera
                if (super.executorPointer.getMap()[i][j].getWorkerOnCell() != null && super.executorPointer.getMap()[i][j].getWorkerOnCell().getOwner() == selectedWorker.getOwner() && check == 1) {
                    check = 0;
                } else if (super.executorPointer.getMap()[i][j].getWorkerOnCell() != null && check == 1) {
                    shiftX = calcolaSpostamentoX(selectedWorker, super.executorPointer.getMap()[i][j]);
                    shiftY = calcolaSpostamentoY(selectedWorker, super.executorPointer.getMap()[i][j]);
                    //se la cella dove si dovrebbe spostare il worker pushato è occupata da un altro worler non aggiungo alla lista delle celle
                    if (super.executorPointer.getMap()[i - shiftX][j - shiftY].getWorkerOnCell() != null) {
                        check = 0;
                    }
                }

                if(check==1){
                    //inserisce nella lista
                    super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells().add(super.executorPointer.getMap()[i][j]);
                }
            }
        }
    }
}
