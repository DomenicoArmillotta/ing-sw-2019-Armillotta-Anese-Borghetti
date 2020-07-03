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


/**
 * handle broadcast communication from server to client
 */

/* SocketHandlerOutput singleton */
public class SocketHandlerOutput implements Runnable {
    private List<Socket> socketList;
    private List<PrintWriter> printWriterList;
    private EventsBuffer eventsBuffer;
    private Controller controller;


    /**
     * create a new socketHandlerOutput
     * @param controller controller created at startUp
     */
    public SocketHandlerOutput(Controller controller) {
        this.controller = controller;
        List<Socket> socketList = new ArrayList<>();
        this.socketList = socketList;
        List<PrintWriter> printWriterList = new ArrayList<>();
        this.printWriterList = printWriterList;
    }

    /**
     * add socket to socketList and create a new printWriter form this socket
     * @param socket socket to add
     * @throws IOException if socket is unavailable
     */
    public void addSocketToList(Socket socket) throws IOException {
        socketList.add(socket);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriterList.add(printWriter);
    }

    /**
     * run and keep sending beans every time that Eventsbuffer isnt' empty.
     * reboot the server when a connection is closed by flushing remaining beans in the parser and set brdLock to false enabling the buffered reader to
     * close itself.
     * Then resets actionExecutor and flush players in the virtualLobby.
     */
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
                    EventsBuffer.instance().setSendEventBeanLock(false);

                    while (controller.getLineClientSocketsAndPortListSize() > 0)
                    ;

                    VvLobby.instance().resetVvLobby();
                    ActionExecutor.instance().nullActionExecutor();
                    //ActionExecutor.instance().resetActionExecutor();
                    resetSocketHandlerOutput();
                    EventsBuffer.instance().setNotEndGame();
                    EventsBuffer.instance().setSendEventBeanLock(true);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * get the last bean in the buffer, parsed it and than send it broadcast across all printwriters
     * @throws JsonProcessingException if xmlMapper fails
     */
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

    /**
     * reset socketList and printWriter.
     */
    public void resetSocketHandlerOutput(){
        socketList.clear();
        printWriterList.clear();
        List<Socket> socketList = new ArrayList<>();
        this.socketList = socketList;
        List<PrintWriter> printWriterList = new ArrayList<>();
        this.printWriterList = printWriterList;
        eventsBuffer.flushBuffer();
    }
}
