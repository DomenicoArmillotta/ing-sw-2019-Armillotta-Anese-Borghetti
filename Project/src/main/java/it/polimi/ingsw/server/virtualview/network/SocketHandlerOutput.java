package it.polimi.ingsw.server.virtualview.network;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/* SocketHandlerOutput singleton */
public class SocketHandlerOutput implements Runnable {
    private List<Socket> socketList;
    private List<PrintWriter> printWriterList;
    private EventsBuffer eventsBuffer;
    private Controller controller;

    private static SocketHandlerOutput instance;

    public static SocketHandlerOutput instance(Controller controller) {
        if (instance == null) {
            instance = new SocketHandlerOutput(controller);
        }
        return instance;
    }

    private SocketHandlerOutput(Controller controller) {
        this.controller = controller;
        List<Socket> socketList = new ArrayList<>();
        this.socketList = socketList;
        List<PrintWriter> printWriterList = new ArrayList<>();
        this.printWriterList = printWriterList;
    }

    public void addSocketToList(Socket socket) throws IOException {
        socketList.add(socket);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriterList.add(printWriter);
    }


    public void run(){

        this.eventsBuffer = EventsBuffer.instance();
        while(true) {
            try {
                while (!EventsBuffer.instance().getEndGame()) {
                    sendingBeans();
                }
                synchronized (eventsBuffer.brdLock) {
                    if (!EventsBuffer.instance().emptyBuffer()) {
                        while (!EventsBuffer.instance().emptyBuffer())
                            sendingBeans();
                    }
                    eventsBuffer.setSendEventBeanLock(false);

                    while (controller.getLineClientSocketsAndPortListSize() > 0)

                        resetSocketHandlerOutput();
                    VvLobby.instance().resetVvLobby();
                    ActionExecutor.instance().resetActionExecutor();
                    resetSocketHandlerOutput();
                    EventsBuffer.instance().setNotEndGame();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public synchronized void sendingBeans() throws JsonProcessingException {

        if(!eventsBuffer.emptyBuffer()) {
            XmlMapper xmlMapper = (new XmlMapper());
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            String toSend = xmlMapper.writeValueAsString(eventsBuffer.getLastEventBean());
            toSend+="\n";
            for(int i = 0; i < printWriterList.size(); i++) {
                printWriterList.get(i).print(toSend);
                printWriterList.get(i).flush();
                System.out.print("Flushed bean: "+toSend);
            }
        }
    }

    public synchronized void quitOutputSocket() throws IOException {
        synchronized (eventsBuffer) {
            for (int i = 0; i < socketList.size() && eventsBuffer.getEndGame(); i++) {
                printWriterList.get(i).close();
                socketList.get(i).close();
                System.out.println("socket status " + socketList.get(i).isClosed());
            }

            socketList.clear();

        }
    }

    public void resetSocketHandlerOutput(){
        if(!socketList.isEmpty())
            socketList.clear();
        List<Socket> socketList = new ArrayList<>();
        this.socketList = socketList;
        List<PrintWriter> printWriterList = new ArrayList<>();
        this.printWriterList = printWriterList;
    }
}
