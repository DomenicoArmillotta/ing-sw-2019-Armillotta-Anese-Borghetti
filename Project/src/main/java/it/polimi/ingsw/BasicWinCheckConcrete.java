package it.polimi.ingsw;

public class BasicWinCheckConcrete implements WinCheckStrategy {
    @Override
    public boolean doWinCheck(Worker movedWorker) {
        if (movedWorker.getCurrentLevel().equals(Level.TOP) && movedWorker.getPreviousLevel().equals(Level.MID)) {
            return true;
        }
        return false;
    }
}
