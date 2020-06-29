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

public class ClientHandler {
        public ClientHandler() {
            startClient();
        }
        public void startClient() {
            int drawerType; /* 0 for CLI, 1 for GUI */
            ExecutorService executor = Executors.newFixedThreadPool(2);
            /* System.out.println("Client ready"); */
            ProxyModel proxyModel = ProxyModel.instance();
            proxyModel.createMap();
            //CliDrawer CliDrawer=new CliDrawer();
            CliDrawer drawer = new CliDrawer();
            drawerType = 0;
            proxyModel.setDrawerStrategy(drawer);
            proxyModel.setPhase(0);
            /* System.out.println("CLI ready"); */
                try {
                    Socket socket = new Socket(Inet4Address.getLocalHost().getHostAddress(), 1234);
                    ProxyModel.instance().thisScoket = socket;
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                    ClientSocketManager.getInstance().setPrintWriter(printWriter);
                    ClientSocketManager.getInstance().setSocket(socket);
                    /* ATTENZIONE */
                    if(drawerType == 0)
                        executor.submit(new ClientHandlerOutput(socket));
                    else
                        proxyModel.getDrawerStrategy().login();

                    //executor.submit(new ClientHandlerOutput(socket)); /* rimuovere */

                    executor.submit(new ClientHandlerInput(socket));
                } catch(IOException e) {
                    executor.shutdown();
                }
        }
}
