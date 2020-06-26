package it.polimi.ingsw.client;

import it.polimi.ingsw.client.proxymodel.CliDrawer;
import it.polimi.ingsw.client.proxymodel.Drawer;
import it.polimi.ingsw.client.proxymodel.GuiDrawer;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {

        public ClientHandler() {
            startClient();
        }
        public void startClient() {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            /* System.out.println("Client ready"); */
            ProxyModel proxyModel = ProxyModel.instance();
            proxyModel.createMap();
            //

            System.out.println("Type "+"\u001B[33m"+"cli"+"\u001B[0m"+" or "+"\u001B[33m"+"gui"+"\u001B[0m");
            Scanner stdin = new Scanner(System.in);

            String inputLine = stdin.next();
            while(!inputLine.equals("cli") && !inputLine.equals("gui")) {
                inputLine = stdin.next();
            }
            Drawer drawer;
            if(inputLine.equals("cli"))
                drawer = new CliDrawer();
            else
                drawer = new GuiDrawer();

            proxyModel.setDrawerStrategy(drawer);
            proxyModel.setPhase(0);

            /* System.out.println("CLI ready"); */
                try {
                    Socket socket = new Socket(Inet4Address.getLocalHost().getHostAddress(), 1234);
                    socket.getPort();
                    executor.submit(new ClientHandlerOutput(socket));
                    executor.submit(new ClientHandlerInput(socket));
                } catch(IOException e) {
                    executor.shutdown();
                }
        }
}
