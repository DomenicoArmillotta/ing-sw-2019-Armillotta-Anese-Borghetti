package it.polimi.ingsw.client.proxymodel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GodsPanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g);
    }

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

        for(int i = 0; i < 3; i++) {
            g.drawImage(imgArray[i], 80+i*140, 5, 840/6, 1410/6, null);
        }
        for(int i = 0; i < 3; i++) {
            g.drawImage(imgArray[i+3], 80+i*140, 235+5, 840/6, 1410/6, null);
        }
        for(int i = 0; i < 3; i++) {
            g.drawImage(imgArray[i+6], 80+i*140, 2*235+5, 840/6, 1410/6, null);
        }
    }
}
