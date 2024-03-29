package it.polimi.ingsw.client.proxymodel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * draw the game screen for selecting the gods
 */
public class GodsPanel extends JPanel {
    /**
     * GUI function for drawing images
     * @param g is used for paint component and derive by override
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g);
    }

    /**
     * the cards of the gods are drawn, based on their position.
     * this screen is shown before the game starts in the god selection phase.
     * also when players select their god with a clic on image, it lights up
     * @param g is used for paint component and derive by override
     */
    private void drawImage(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        ClassLoader cl = this.getClass().getClassLoader();
        Graphics2D g2d = (Graphics2D) g;
        InputStream urlArray[] = new InputStream[9];
        for(int i = 0; i < 9; i++) {
            urlArray[i] = cl.getResourceAsStream("godpics/"+i+".png");
        }

        BufferedImage imgArray[] = new BufferedImage[9];

        try {
            for(int i = 0; i < 9; i++) {
                imgArray[i] = ImageIO.read(urlArray[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        int i = 0;

        for(i = 0; i < 3; i++) {
            g.drawImage(imgArray[i], 80 + i * 140, 5, 840 / 6, 1410 / 6, null);
            g.setColor(new Color(20, 20, 20, 80));
            g.fillRect(80 + i * 140, 5, 840 / 6, 1410 / 6);
        }
        for( i = 0; i < 3; i++) {
            g.drawImage(imgArray[i+3], 80+i*140, 235+5, 840/6, 1410/6, null);
            g.setColor(new Color(20, 20, 20, 80));
            g.fillRect(80+i*140, 235+5, 840/6, 1410/6);
        }
        for( i = 0; i < 3; i++) {
            g.drawImage(imgArray[i+6], 80+i*140, 2*235+5, 840/6, 1410/6, null);
            g.setColor(new Color(20, 20, 20, 80));
            g.fillRect(80+i*140, 2*235+5, 840/6, 1410/6);
        }

        for(int k = 0; k < Display.instance().getMouseListenerGodCards().getSelectableGods().size(); k++) {
            switch (Display.instance().getMouseListenerGodCards().getSelectableGods().get(k).getY()) {
                case 0:
                    switch (Display.instance().getMouseListenerGodCards().getSelectableGods().get(k).getX()) {
                        case 0: i = 0;
                                break;
                        case 1: i = 1;
                                break;
                        case 2: i = 2;
                                break;
                    }
                    g.drawImage(imgArray[i], 80 + i * 140, 5, 840 / 6, 1410 / 6, null);
                    break;
                case 1:
                    switch (Display.instance().getMouseListenerGodCards().getSelectableGods().get(k).getX()) {
                        case 0: i = 0;
                                break;
                        case 1: i = 1;
                                break;
                        case 2: i = 2;
                                break;
                    }
                    g.drawImage(imgArray[i + 3], 80 + i * 140, 235 + 5, 840 / 6, 1410 / 6, null);
                    break;
                case 2:
                    switch (Display.instance().getMouseListenerGodCards().getSelectableGods().get(k).getX()) {
                        case 0: i = 0;
                                break;
                        case 1: i = 1;
                                break;
                        case 2: i = 2;
                                break;
                    }
                    g.drawImage(imgArray[i + 6], 80 + i * 140, 2 * 235 + 5, 840 / 6, 1410 / 6, null);
                    break;
            }
        }
    }
}
