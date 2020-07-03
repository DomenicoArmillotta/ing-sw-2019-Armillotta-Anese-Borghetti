package it.polimi.ingsw;

import it.polimi.ingsw.client.ClientHandler;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;


public class Main {
    static private int portNumber =1234;
    public static void main(String[] Args) {
        System.out.println("Nuova stampa di prova");

        int paramnsCount = Args.length;

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


    public static void startGui(int portNumber){
        System.out.println("gui");
        ClientHandler clientHandler = new ClientHandler("gui",portNumber);
        clientHandler.startClient();
    }
    public static void startCli(int portNumber){
        System.out.println("cli");
        ClientHandler clientHandler = new ClientHandler("cli",portNumber);
        clientHandler.startClient();
    }
    public static void startServer(int portNumber){
        NetworkHandler networkHandler = new NetworkHandler(portNumber);
        networkHandler.startServer();
        System.out.println("server");
    }
}
