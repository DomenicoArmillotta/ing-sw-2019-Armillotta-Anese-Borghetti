package it.polimi.ingsw.client;
/**
 * the event is sent to the server by the client,with the answer of boolean choice
 */
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
