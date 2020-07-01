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

/**
 * used to click on the choice that is offered when playing whether or not you want to use the power of the god you are using.
 * The selection is located at the bottom and has two yes or no choices of green and red color respectively
 */
public class MouseListenerChoice implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("WOW! Clicked with MouseListenerChoice");
        int x = e.getX();
        int y = e.getY();
        PrintWriter printWriter = ClientSocketManager.getInstance().getPrintWriter();
        XmlMapper xmlMapper = (new XmlMapper());
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        if((Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals("")) && x < 300 && y > 500) {
            //System.out.println("\u001B[32m"+"CLICKED ON BUTTON YES"+x+" "+y+"\u001B[0m");
            //Display.instance().setPrompt("");
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            String toSend = null;
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(true));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
            toSend += "\n";
            printWriter.print(toSend);
            printWriter.flush();
            //System.out.println("yes");
        } else if((Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals("")) && y > 500) { // (Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals(""))
            //System.out.println("\u001B[32m"+"CLICKED ON BUTTON NO"+x+" "+y+"\u001B[0m");
            //Display.instance().setPrompt("");
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            String toSend = null;
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(false));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
            toSend += "\n";
            printWriter.print(toSend);
            printWriter.flush();
            //System.out.println("no");
        }
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
