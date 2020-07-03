package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create GameStartEventBean which will be sent to the client by the server to start the game
 */
public class GameStartEventBean extends EventBean{
    private String firstPlayer;
    private String secondPlayer;
    private String thirdPlayer;

    /**
     *create GameStartEventBean which will be sent to the client by the server to start the game,
     * setting the position of the players in order in the turn
     * @param firstPlayer
     * @param secondPlayer
     * @param thirdPlayer
     */
    public GameStartEventBean(String firstPlayer, String secondPlayer, String thirdPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public String getThirdPlayer() {
        return thirdPlayer;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public void setThirdPlayer(String thirdPlayer) {
        this.thirdPlayer = thirdPlayer;
    }
}
