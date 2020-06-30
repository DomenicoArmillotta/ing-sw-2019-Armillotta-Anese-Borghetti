package it.polimi.ingsw.server.model.powertree;

/**
 * extends FindAvailableCellsBuild , override superClass doAction() and compute cells before any type of move
 */

public class FindAvailableCellsBuildBeforeMove extends FindAvailableCellsBuild {
    /**
     * call super.doAction()
     * @param userInput this method doesn't require a particular userInput;
     * @return 1  if buildableCells is not empty else -1;
     */
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(null) == 0)
            return 1;
        return  -1;
    }
}
