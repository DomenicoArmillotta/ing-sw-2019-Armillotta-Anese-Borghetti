package it.polimi.ingsw.client.viewevents;

public class DomePromptViewEvent extends ViewEvent{
    private String domeRequest;

    public DomePromptViewEvent(String domeRequest){
        this.domeRequest = domeRequest;
    }
    @Override
    public void viewEventMethod() {
        System.out.println("CLI_PROMPT: "+domeRequest);
    }
}
