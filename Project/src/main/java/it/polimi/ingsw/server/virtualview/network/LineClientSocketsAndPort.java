package it.polimi.ingsw.server.virtualview.network;

import java.net.Socket;

/**
 * tuple of socket and socketPort that characterize a single client
 */
public class LineClientSocketsAndPort {
    private Socket socket;
    private String port;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    /**
     * creates a new LineClientSocketAndPort with this socket and port
     * @param socket current client socket
     * @param port current socket's port
     */
    public LineClientSocketsAndPort(Socket socket,int port){
        this.socket = socket;
        this.port = Integer.toString(port);
    }
}
