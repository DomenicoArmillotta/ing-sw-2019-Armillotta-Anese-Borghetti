package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class CorrectPromptAnswer extends EventBean{
    boolean answer;

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
