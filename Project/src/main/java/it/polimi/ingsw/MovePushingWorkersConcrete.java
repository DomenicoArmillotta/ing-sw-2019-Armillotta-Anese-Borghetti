package it.polimi.ingsw;

public class MovePushingWorkersConcrete implements MoveWorkerStrategy {

    public Worker WorkerSpostato(Cell selectedCell) {
        return selectedCell.getWorkerOnCell();
    }

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
/*
    public Cell sposta(Worker workerDaSpostare, int X, int Y) {
        cellaDaSpostare.setX(cellaDaSpostare.getX() + X);
        cellaDaSpostare.setY(cellaDaSpostare.getY() + Y);
        return cellaDaSpostare;
    }*/

    @Override
    public void doMoveWorker(Worker selectedWorker, Cell selectedCell) {

        if (selectedCell.getWorkerOnCell() == null) {
            selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
            selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
            selectedCell.setWorkerOnCell(selectedWorker);
            selectedWorker.setCurrentPosition(selectedCell);
            selectedWorker.setCurrentLevel(selectedCell.getBuildingLevel());

        } else {
            Worker workerDaSpostare = selectedCell.getWorkerOnCell();
            selectedWorker.setPreviousLevel(selectedWorker.getCurrentLevel());
            selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
            workerDaSpostare.setPreviousLevel(workerDaSpostare.getCurrentLevel());
            workerDaSpostare.setPreviousPosition(workerDaSpostare.getCurrentPosition());

            int shiftX=calcolaSpostamentoX(selectedWorker,selectedCell);
            int shiftY=calcolaSpostamentoY(selectedWorker,selectedCell);
            selectedWorker.getOwner().getCurrentMatch().getMap()[workerDaSpostare.getCurrentPosition().getX()-shiftX][workerDaSpostare.getCurrentPosition().getY()-shiftY].setWorkerOnCell(workerDaSpostare);
            workerDaSpostare.getCurrentPosition().setWorkerOnCell(null);
            workerDaSpostare.setCurrentPosition(selectedWorker.getOwner().getCurrentMatch().getMap()[workerDaSpostare.getCurrentPosition().getX()-shiftX][workerDaSpostare.getCurrentPosition().getY()-shiftY]);
            selectedWorker.setCurrentPosition(selectedCell);


        }


    }
}
