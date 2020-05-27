package it.polimi.ingsw.client;

public class BooleanEvent extends ClientEvent {
    Boolean answer;

    public BooleanEvent(Boolean answer) {
        this.answer = answer;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}
