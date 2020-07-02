package it.polimi.ingsw;

import it.polimi.ingsw.client.ClientHandler;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;

import java.util.Arrays;

public class Main {
    static private int portNumber =1234;
    public static void main(String[] Args) {
        /*
        entry point assoluto,
         */
        int paramnsCount = Args.length;
        /*for (int i = 0; i < paramnsCount; i++) {
            System.out.println(Args[i]);
        }*/
        if(paramnsCount==2){
            portNumber = Integer.parseInt(Args[1]);
        }

        if (paramnsCount == 0) {
            startGui(portNumber);
        } else if (Args[0].equals("server")) {
            startServer(portNumber);
        } else if (Args[0].equals("cli")) {

            startCli(portNumber);
        } else if (Args[0].equals("gui")) {

            startGui(portNumber);
        } else
            System.out.println("errore");

    }

        /*System.out.println("write 'server' server or 'client' for client the write 'gui' for the Gui else write 'cli' for cli. enjoy");
        if(Args[0].equals("server")){
            NetworkHandler networkHandler = new NetworkHandler(1234);
            networkHandler.startServer();
        }
        if(Args[0].equals("client")){
            ClientHandler clientHandler = new ClientHandler(Args[1]);
            clientHandler.startClient();
        }*/
    public static void startGui(int portNumber){
        System.out.println("gui");
        ClientHandler clientHandler = new ClientHandler("gui");
        clientHandler.startClient();
    }
    public static void startCli(int portNumber){
        System.out.println("cli");
        ClientHandler clientHandler = new ClientHandler("cli");
        clientHandler.startClient();
    }
    public static void startServer(int portNumber){
        NetworkHandler networkHandler = new NetworkHandler(portNumber);
        networkHandler.startServer();
        System.out.println("server");
    }
}
