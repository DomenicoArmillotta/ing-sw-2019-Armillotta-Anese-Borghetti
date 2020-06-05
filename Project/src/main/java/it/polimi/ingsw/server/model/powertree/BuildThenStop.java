package it.polimi.ingsw.server.model.powertree;

public class BuildThenStop extends Build {
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(userInput) == 1)
            return 0;
        return  -1;
    }
}
