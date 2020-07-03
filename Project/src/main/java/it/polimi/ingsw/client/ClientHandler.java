package it.polimi.ingsw.client;

import it.polimi.ingsw.client.proxymodel.CliDrawer;
import it.polimi.ingsw.client.proxymodel.GuiDrawer;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *it is the main thread for communication and starts the other two handlers, that is, the input and output handlers
 */
public class ClientHandler {
    private String drawerType;
    private int portNumber;

        public ClientHandler(String drawerChoice,int portNumber) {
            this.drawerType = drawerChoice;
            System.out.println("start client");
            this.portNumber = portNumber;
        }

    /**
     * it is chosen whether to start the gui or the cli, the port for the communication is chosen and the socket is created
     * the login is started
     *
     */
    public void startClient() {
            int drawerType; /* 0 for CLI, 1 for GUI */
            ExecutorService executor = Executors.newCachedThreadPool();
            /* System.out.println("Client ready"); */
            ProxyModel proxyModel = ProxyModel.instance();
            proxyModel.createMap();
            if(this.drawerType.equals("gui")){
                GuiDrawer guiDrawer = new GuiDrawer();
                proxyModel.setDrawerStrategy(guiDrawer);
                drawerType = 1;
            }else
                if(this.drawerType.equals("cli")){
                    CliDrawer cliDrawer = new CliDrawer();
                    drawerType = 0;
                    proxyModel.setDrawerStrategy(cliDrawer);
                }else {
                    System.out.println("inserted draw method unavailable, pleas reinsert");
                    return;
                }

            proxyModel.setPhase(0);

                try {
                    Socket socket = new Socket(Inet4Address.getLocalHost(), this.portNumber);
                    ProxyModel.instance().thisScoket = socket;
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                    ClientSocketManager.getInstance().setPrintWriter(printWriter);
                    ClientSocketManager.getInstance().setSocket(socket);

                    if(drawerType == 0)
                        executor.submit(new ClientHandlerOutput(socket));
                    else
                        proxyModel.getDrawerStrategy().login();

                    executor.submit(new ClientHandlerInput(socket));
                } catch(IOException e) {
                    executor.shutdown();
                }
        }
}
