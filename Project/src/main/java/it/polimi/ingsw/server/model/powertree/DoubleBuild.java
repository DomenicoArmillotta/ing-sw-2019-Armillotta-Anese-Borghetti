package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.mvevents.actionevents.DoubleBuildEvent;

/**
 *  check if a worker is able to build another time ather their previous build.
 *
 */


public class DoubleBuild extends Power {


 /**
  * override superClass doAction and returns 0, call createPromptListener and pass a new DoubleBuildEvent.
  * @return 1 if a second move is not allowed due to the lack of available cells to build, 0 if is allowed
 */
    @Override
    public int doAction(int[] userInput) {
        /*creo nuovi listener*/
        ActionExecutor actionExecutor = ActionExecutor.instance();
        int selectedWorker = getWorkerIndex();
        /*//refactor
        int selectedWorker;
        if(actionExecutor.getPrevSelect().getSelectedWorker().equals(actionExecutor.getCurrentPlayer().getFirstWorker()))
            selectedWorker = 0;
        else
            selectedWorker = 1;
        */
        if(actionExecutor.getNextBuild().getAvailableCells(selectedWorker).isEmpty()) {
            return 1; // non ci sono celle disponibili per questo worker quindi passiamo oltre
        }
        else{
            super.getBooleanActionListener().createPromptBean(new DoubleBuildEvent());
        }
        return 0;
    }
}
