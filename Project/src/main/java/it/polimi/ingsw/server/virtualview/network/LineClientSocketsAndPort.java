package it.polimi.ingsw.server.virtualview.network;

import java.net.Socket;


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

    public LineClientSocketsAndPort(Socket socket,int port){
        this.socket = socket;
        this.port = Integer.toString(port);
    }
}
