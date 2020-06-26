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

public class NetworkHandler {
    private int port;
    public NetworkHandler(int port) {
        this.port = port;
    }
    public void startServer() throws ParserConfigurationException, SAXException, IOException {
        Controller controller = new Controller();
        ActionExecutor executorPointer = ActionExecutor.instance();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ServerSocket serverSocket;
        SocketHandlerOutput socketHandlerOutput = SocketHandlerOutput.instance(controller);
        executor.submit(socketHandlerOutput);
        //PingHandler pingHandler;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
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