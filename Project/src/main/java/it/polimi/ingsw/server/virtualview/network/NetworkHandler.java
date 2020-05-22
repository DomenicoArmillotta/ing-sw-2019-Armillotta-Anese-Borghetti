package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkHandler {
    private int port;
    public NetworkHandler(int port) {
        this.port = port;
    }
    public void startServer() {
        Controller controller = new Controller();
        ActionExecutor executorPointer = ActionExecutor.instance();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ServerSocket serverSocket;
        SocketHandlerOutput socketHandlerOutput = SocketHandlerOutput.instance();
        executor.submit(socketHandlerOutput);
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println(e.getMessage()); // Porta non disponibile
            return;
        }
        ServerStatus serverStatus = ServerStatus.instance();
        serverStatus.setGamePhase(GamePhase.LOGIN);
        System.out.println("Server ready");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                    //System.out.println("New connection Input");
                executor.submit(new SocketHandlerInput(socket, controller, executorPointer, serverStatus));
                //socket = serverSocket.accept();
                    /* executor.submit(new SocketHandlerInput(socket, controller, executorPointer)); */
                    //System.out.println("New connection Output, socket: "+socket);
                socketHandlerOutput.addSocketToList(socket);
                /* addSocketToList(socket); */
            } catch(IOException e) {
                break; // Entrerei qui se serverSocket venisse chiuso
            }
        }
        executor.shutdown();
    }
}