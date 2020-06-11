package it.polimi.ingsw.client.proxymodel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class BoardPanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g);
    }

    private void drawImage(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        ClassLoader cl = this.getClass().getClassLoader();
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        Graphics2D g4 = (Graphics2D) g;

        InputStream url1 = cl.getResourceAsStream("pawn1.png");
        InputStream url2 = cl.getResourceAsStream("pawn2.png");
        InputStream url3 = cl.getResourceAsStream("SantoriniBoard.png");
        InputStream url4 = cl.getResourceAsStream("block1.png");
        InputStream url5 = cl.getResourceAsStream("block2.png");
        InputStream url6 = cl.getResourceAsStream("block3.png");
        InputStream url7 = cl.getResourceAsStream("block4.png");

        BufferedImage img1 = null;
        BufferedImage img2 = null;
        BufferedImage img3 = null;
        BufferedImage img4 = null;
        BufferedImage img5 = null;
        BufferedImage img6 = null;
        BufferedImage img7 = null;

        try {
            img1 = ImageIO.read(url1);
            img2 = ImageIO.read(url2);
            img3 = ImageIO.read(url3);
            img4 = ImageIO.read(url4);
            img5 = ImageIO.read(url5);
            img6 = ImageIO.read(url6);
            img7 = ImageIO.read(url7);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //322 114
        int firstCellX = 322;
        int firstCellY = 114;
        int shift = 80;

        g.drawImage(img3, 0, 0, 960, 540, null);

        ClientCell[][] map = proxyModel.getMap();
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++) {
                switch (map[i][j].getLevel()) {
                    case 1: g.drawImage(img4, firstCellX - 25 + shift * i, firstCellY - 25  + shift * j, 50, 50, null);
                            break;
                    case 2: g.drawImage(img5, firstCellX - 25 + shift * i, firstCellY - 25  + shift * j, 50, 50, null);
                            break;
                    case 3: g.drawImage(img6, firstCellX - 25 + shift * i, firstCellY - 25  + shift * j, 50, 50, null);
                            break;
                    case 4: g.drawImage(img7, firstCellX - 25 + shift * i, firstCellY - 25  + shift * j, 50, 50, null);
                            break;
                    default: break;
                }
                /* System.out.println("i: "+i+" j: "+j+" selectable: "+map[i][j].getSelectable()); */
                if(map[i][j].getSelectable() == 1) {
                    g2.setColor(new Color(255, 0, 0, 80));
                    g2.fillRect(firstCellX - 40 + shift * i,firstCellY - 40  + shift * j,80,80);
                }
                /* switch (map[i][j].getSelectable()) {
                    case 0:  if(i%2==0) g2.setColor(new Color(0, 255, 0, 80));
                            if(i%2==0) g2.fillRect(firstCellX - 40 + shift * i,firstCellY - 40  + shift * j,80,80);
                            break;
                    case 1:  System.out.println("Banana");
                             g3.setColor(new Color(255, 0, 0, 80));
                             g3.fillRect(firstCellX - 40 + shift * i,firstCellY - 40  + shift * j,80,80);
                             break;
                    default: break;
                } */
            }

        //g2.setColor(new Color(0, 255, 0, 50));
        //g2.fillRect(firstCellX - 40 + shift * 3,firstCellY - 40  + shift * 3,80,80);

        if(proxyModel.getPlayers().size() > 1 && proxyModel.getPlayers().get(0).getWorker1() != null) {
            int wx1p1 = proxyModel.getPlayers().get(0).getWorker1().getPosition().getX();
            int wy1p1 = proxyModel.getPlayers().get(0).getWorker1().getPosition().getY();
            int wx2p1 = proxyModel.getPlayers().get(0).getWorker2().getPosition().getX();
            int wy2p1 = proxyModel.getPlayers().get(0).getWorker2().getPosition().getY();

            g.drawImage(img1, firstCellX - 25 + shift * wx1p1, firstCellY - 25  + shift * wy1p1, 50, 50, null);
            g.drawImage(img1, firstCellX - 25  + shift * wx2p1, firstCellY - 25  + shift * wy2p1, 50, 50, null);
            }

        if(proxyModel.getPlayers().size() > 1 && proxyModel.getPlayers().get(1).getWorker1() != null) {
            int wx1p2 = proxyModel.getPlayers().get(1).getWorker1().getPosition().getX();
            int wy1p2 = proxyModel.getPlayers().get(1).getWorker1().getPosition().getY();
            int wx2p2 = proxyModel.getPlayers().get(1).getWorker2().getPosition().getX();
            int wy2p2 = proxyModel.getPlayers().get(1).getWorker2().getPosition().getY();

            g.drawImage(img2, firstCellX - 25  + shift * wx1p2, firstCellY - 25  + shift * wy1p2, 50, 50, null);
            g.drawImage(img2, firstCellX - 25  + shift * wx2p2, firstCellY - 25  + shift * wy2p2, 50, 50, null);

        }


;

        /* g.drawImage(img1, 322-(50/2), 114-(50/2), 50, 50, null);
        g.drawImage(img2, 322-(50/2)+80, 114-(50/2), 50, 50, null);
        g.drawImage(img1, 322-(50/2)+80*2, 114-(50/2)+80*3, 50, 50, null);
        g.drawImage(img2, 322-(50/2)+80*3, 114-(50/2), 50, 50, null); */
    }
}
