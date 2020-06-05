package it.polimi.ingsw.server.model.powertree;

public class SelectThenSkip extends Select {
    @Override
    public int doAction(int[] userInput) {
        if(super.doAction(userInput) == 0)
            return 1;
        return  -1;
    }
}
