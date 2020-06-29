package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class DomePromptViewEvent extends ViewEvent{
    private String domeRequest;

    public DomePromptViewEvent(String domeRequest){
        this.domeRequest = domeRequest;
    }
    @Override
    public void viewEventMethod() {
        ProxyModel.instance().getDrawerStrategy().promptChoice(domeRequest);
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m"+", "+domeRequest);
        System.out.println("Answer by typing "+"\u001B[33m"+"bool"+"\u001B[0m"+" followed by "+"\u001B[33m"+"true"+"\u001B[0m"+" or "+"\u001B[33m"+"false"+"\u001B[0m"+".");
        System.out.println("If "+"\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m"+" answers "+"\u001B[33m"+"false"+"\u001B[0m"+", he/she should then build a regular block typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed the desired "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");

    }
}
