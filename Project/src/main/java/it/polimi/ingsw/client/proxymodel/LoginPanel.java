package it.polimi.ingsw.client.proxymodel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoginPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawImage(g);
        }

        private void drawImage(Graphics g) {
            ProxyModel proxyModel = ProxyModel.instance();
            ClassLoader cl = this.getClass().getClassLoader();
            Graphics2D g2d = (Graphics2D) g;
            InputStream url = cl.getResourceAsStream("title.png");
            BufferedImage img = null;

            try {
                img = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            Font font = new Font("Serif", Font.PLAIN, 24);
            g2d.drawImage(img, 0, 0, 600, 600, null);
            g2d.setColor(new Color(20, 20, 20));
            g2d.setFont(font);
            g2d.drawString("SANTORINI BOARD GAME GUI SIMULATION", 15, 640);

            /*
            g2d.drawImage(img, 0, 0, 600, 600, null);
            JTextField textField = new JTextField("Nickname",20);
            textField.setFont(font);
            this.add(textField);

             */

        }

}
