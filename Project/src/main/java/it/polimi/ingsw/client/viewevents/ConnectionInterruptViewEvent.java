package it.polimi.ingsw.client.viewevents;
import it.polimi.ingsw.client.proxymodel.ProxyModel;
import java.net.Socket;

/**
 * used for display a message when a connection is lost
 */
public class ConnectionInterruptViewEvent extends ViewEvent{
    private String faultyClient;
    ProxyModel proxyModel = ProxyModel.instance();
    Socket socket = proxyModel.thisScoket;


    public ConnectionInterruptViewEvent(String faultyClient){
        this.faultyClient = faultyClient;
        this.proxyModel = ProxyModel.instance();
    }

    /**
     * draw a text when the connection has a interrupt
     */
    @Override
    public void viewEventMethod(){
        proxyModel.getDrawerStrategy().drawConnectionInterrupt();
        proxyModel.setPhase(-1);
    }
}
