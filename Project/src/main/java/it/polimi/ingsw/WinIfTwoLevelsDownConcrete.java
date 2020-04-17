package it.polimi.ingsw;

public class WinIfTwoLevelsDownConcrete implements WinCheckStrategy {
    @Override
    public boolean doWinCheck(Worker movedWorker) {
        if (movedWorker.getPreviousLevel().ordinal() - movedWorker.getCurrentLevel().ordinal() >= 2) {
            return true;
        }
        return false;
    }
}
