package it.polimi.ingsw.server.model.powertree;
/**
 * extends FindAvailableCellsBuild
 */
public class FindAvailableCellsBuildInstantDome extends FindAvailableCellsBuild{
    /**
     * call super.doAction() and if return 0 return 1, executing the next Power Autonomously else
     * return -1;
     * @param userInput this method doesn't require a particular userInput;
     * @return 1 if super.doAction returned 0 else -1;
     */
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(null) == 0)
            return 1;
        return  -1;
    }
}
