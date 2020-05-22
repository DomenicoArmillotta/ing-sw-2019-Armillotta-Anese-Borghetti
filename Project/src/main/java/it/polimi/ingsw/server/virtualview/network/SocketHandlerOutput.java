package it.polimi.ingsw.server.virtualview.network;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/* SocketHandlerOutput singleton */
public class SocketHandlerOutput implements Runnable {
    private List<Socket> socketList;
    private List<PrintWriter> printWriterList;
    private PrintWriter printWriterPtr;
    private EventsBuffer eventsBuffer;
    private ServerStatus serverStatus = ServerStatus.instance();

    private static SocketHandlerOutput instance;

    public static SocketHandlerOutput instance() {
        if (instance == null) {
            instance = new SocketHandlerOutput();
        }
        return instance;
    }

    private SocketHandlerOutput() {
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


    public void run() {
        try {
            this.eventsBuffer = EventsBuffer.instance();

            while (!serverStatus.equals(null)) {
                sendingBeans();
            }
            while (serverStatus.getGamePhase().equals(GamePhase.GAME)) {
                sendingBeans();
            }
            for(int i = 0; i < socketList.size(); i++) {
                socketList.get(i).close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
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
            //eventsBuffer.flushBuffer();
        }
    }

}
