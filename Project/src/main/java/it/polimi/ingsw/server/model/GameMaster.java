package it.polimi.ingsw.server.model;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import java.util.List;
public class GameMaster {

    private List<Player> playerQueue;
    private int numOfPlayers;
    private ActionExecutor actionExecutor;
    private GodCardsDeck godCardsDeck = new GodCardsDeck();

    /**
     *  is the constructor and set the number of players and the queue of players, which is used to manage the turn
     *  create the ActionExecutor
     * @param playerQueue
     * @param numOfPlayers
     */
    public GameMaster(List<Player> playerQueue, int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        this.playerQueue = playerQueue;
        //createGodList();
        createActionExecutor();
        getActionExecutor().cleanActionExecutor();
    }

    /**
     * whether the game has two or three players
     * set the mortal as the god of default who has no particular powers and also set prev and next player to manage the turns
     */
    public void createActionExecutor() {
        this.actionExecutor = ActionExecutor.instance();
        if (numOfPlayers == 2) {
            for (int i = 0; i < 2; i++) {
                /*GodCard is Mortal by default for every Player, then it can be changed*/
                    playerQueue.get(i).setPlayerGod(godCardsDeck.createGodCard("mortal"));
                }

            this.actionExecutor.setCurrentPlayer(playerQueue.get(0));
            this.actionExecutor.setNextPlayer(playerQueue.get(1));
            this.actionExecutor.setPrevPlayer(playerQueue.get(1));
        } else if (numOfPlayers == 3) {
            for (int i = 0; i < 3; i++) {
                /*GodCard is Mortal by default for every Player, then it can be changed*/
                    playerQueue.get(i).setPlayerGod(godCardsDeck.createGodCard("mortal"));

            }
            this.actionExecutor.setCurrentPlayer(playerQueue.get(0));
            this.actionExecutor.setNextPlayer(playerQueue.get(1));
            this.actionExecutor.setPrevPlayer(playerQueue.get(2));
        }
    }

    public ActionExecutor getActionExecutor() {
        return this.actionExecutor;
    }

    public int getNumOfPlayers() {
        return this.numOfPlayers;
    }

}
