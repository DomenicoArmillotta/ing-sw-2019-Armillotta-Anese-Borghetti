package it.polimi.ingsw.client.proxymodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.BooleanEvent;
import it.polimi.ingsw.client.ClientSocketManager;
import it.polimi.ingsw.client.GodChoiceEvent;
import it.polimi.ingsw.client.GodListEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class MouseListenerChoice implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked with MouseListenerChoice");
        int x = e.getX();
        int y = e.getY();
        PrintWriter printWriter = ClientSocketManager.getInstance().getPrintWriter();
        XmlMapper xmlMapper = (new XmlMapper());
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        String toSend = null;
        if(x < 300) {
            System.out.println("yes");
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(true));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        }
        else {
            System.out.println("no");
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(false));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        }
        toSend += "\n";
        printWriter.print(toSend);
        printWriter.flush();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
