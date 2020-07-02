package it.polimi.ingsw.client.proxymodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.BooleanEvent;
import it.polimi.ingsw.client.ClientSocketManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;

/**
 * used to click on the choice that is offered when playing whether or not you want to use the power of the god you are using.
 * The selection is located at the bottom and has two yes or no choices of green and red color respectively
 */
public class MouseListenerChoice implements MouseListener {
    /**
     *
     if you are in the right phase, you choose whether to use the power of god if the click takes place in the position
     *where the word yes or no is positioned
     * @param e
     */
    private Display display;
    private static int threshX = 300;
    private static int threshY = 600;

    public MouseListenerChoice(Display display) {
        this.display = display;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        PrintWriter printWriter = ClientSocketManager.getInstance().getPrintWriter();
        XmlMapper xmlMapper = (new XmlMapper());
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        String toSend = null;
        if(display.getButtonAnswer() == 0 && (display.getGraphicsFlag() == 5) && x < threshX && y > threshY) {
            display.setButtonAnswer(1);
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(true));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        } else if(display.getButtonAnswer() == 0 && (display.getGraphicsFlag() == 5) && y > threshY) {
            display.setButtonAnswer(2);
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(false));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        }
        if(toSend != null) {
            toSend += "\n";
            printWriter.print(toSend);
            printWriter.flush();
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
