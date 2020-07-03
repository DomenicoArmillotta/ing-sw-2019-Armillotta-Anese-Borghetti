package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create the CorrectPromptAnswer
 */
public class CorrectPromptAnswer extends EventBean{
    boolean answer;

    /**
     *is the constructor of CorrectPromptAnswer is created and sent from the server to the client
     * to communicate the correct answer after checking it on the server
     * @param answer
     */
    public CorrectPromptAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
