package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * main class of the virtualView, manage all incoming connections and creates SocketHandlerInputs and the only SocketHandlerOutput.
 */
public class NetworkHandler {
    private int port;
    public NetworkHandler(int port) {
        this.port = port;
    }

    /**
     * start the server by creating SocketHandlerOutput and a threasd for every SocketHandlerInput.

     */
    public void startServer(){
        Controller controller = new Controller();
        ActionExecutor executorPointer = ActionExecutor.instance();
        ExecutorService executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket;
        SocketHandlerOutput socketHandlerOutput = new SocketHandlerOutput(controller);
        executor.submit(socketHandlerOutput);

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("unavailable port");
            System.err.println(e.getMessage()); // Porta non disponibile
            return;
        }

        System.out.println("Server ready");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                /* new class method per aggingerla alla lista*/
                executor.submit(new SocketHandlerInput(socket, controller));
                socketHandlerOutput.addSocketToList(socket);
                /* addSocketToList(socket); */
            } catch(IOException e) {
                break;
            }
        }
        executor.shutdown();
    }
}