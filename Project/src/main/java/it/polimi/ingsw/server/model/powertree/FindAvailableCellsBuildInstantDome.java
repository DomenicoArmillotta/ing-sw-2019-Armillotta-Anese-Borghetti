package it.polimi.ingsw.server.model.powertree;

public class FindAvailableCellsBuildInstantDome extends FindAvailableCellsBuild{
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(null) == 0)
            return 1;
        return  -1;
    }
}
