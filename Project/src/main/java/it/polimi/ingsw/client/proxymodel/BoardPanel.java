package it.polimi.ingsw.client.proxymodel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class BoardPanel extends JPanel {

    public String getPrompt() {
        Display display = Display.instance();
        return display.getPromptText();
    }

    public void setPrompt(String promptText) {
        Display display = Display.instance();
        display.setPrompt(promptText);
    }

    public int getGraphicsFlag() {
        Display display = Display.instance();
        return display.getGraphicsFlag();
    }

    public void setGraphicsFlag(int graphicsFlag) {
        Display display = Display.instance();
        display.setGraphicsFlag(graphicsFlag);
    }

    /**
     *this function is used to switch on a case-by-case basis what to write in the prompt and indicate what to do in the various turn and phases
     * writeText1=text to give indications to select the worker
     * writeText2=text to give indications to move the worker selected
     * writeText3=text to give indications to build block
     * writeText4=text to give indications to place worker
     * writeText5=shows the choice to choose between yes or no, when the power of god can be used
     * writeText6=text that is shown when someone wins
     * writeText7=text that is shown when someone lost the game
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g);

        switch(getGraphicsFlag()) {
            case 1: writeText1(g);
                    break;
            case 2: writeText2(g);
                    break;
            case 3: writeText3(g);
                    break;
            case 4: writeText4(g);
                    break;
            case 5: writeText5(g);
                    break;
            case 6: writeText6(g);
                    break;
            case 7: writeText7(g);
                    break;
            case 0: ;
                    break;
        }
    }

    private void drawImage(Graphics g) {
            ProxyModel proxyModel = ProxyModel.instance();
            ClassLoader cl = this.getClass().getClassLoader();
            Graphics2D g2 = (Graphics2D) g;
            Graphics2D g3 = (Graphics2D) g;
            Graphics2D g4 = (Graphics2D) g;

            InputStream url1 = cl.getResourceAsStream("pawn1.png");
            InputStream url2 = cl.getResourceAsStream("pawn2.png");
            InputStream url3 = cl.getResourceAsStream("grid.png");
            InputStream url4 = cl.getResourceAsStream("block1.png");
            InputStream url5 = cl.getResourceAsStream("block2.png");
            InputStream url6 = cl.getResourceAsStream("block3.png");
            InputStream url7 = cl.getResourceAsStream("block4.png");
            InputStream url8 = cl.getResourceAsStream("pawn3.png");

            BufferedImage img1 = null;
            BufferedImage img2 = null;
            BufferedImage img3 = null;
            BufferedImage img4 = null;
            BufferedImage img5 = null;
            BufferedImage img6 = null;
            BufferedImage img7 = null;
            BufferedImage img8 = null;


            try {
                img1 = ImageIO.read(url1);
                img2 = ImageIO.read(url2);
                img3 = ImageIO.read(url3);
                img4 = ImageIO.read(url4);
                img5 = ImageIO.read(url5);
                img6 = ImageIO.read(url6);
                img7 = ImageIO.read(url7);
                img8 = ImageIO.read(url8);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            //322 114
            int firstCellX = 64;
            int firstCellY = 64;
            int shift = 118;

            g.drawImage(img3, 0, 0, 600, 600, null);

            ClientCell[][] map = proxyModel.getMap();
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++) {
                    switch (map[i][j].getLevel()) {
                        case 1:
                            g.drawImage(img4, 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                            break;
                        case 2:
                            g.drawImage(img5, 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                            break;
                        case 3:
                            g.drawImage(img6, 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                            break;
                        case 4:
                            g.drawImage(img7, 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                            break;
                        default:
                            break;
                    }
                    /* System.out.println("i: "+i+" j: "+j+" selectable: "+map[i][j].getSelectable()); */
                    if (map[i][j].getSelectable() == 1) {
                        g2.setColor(new Color(255, 0, 0, 80));
                        g2.fillRect(10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20);
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

            if (proxyModel.getPlayers().size() > 1 && proxyModel.getPlayers().get(0).getWorker1() != null) {
                int wx1p1 = proxyModel.getPlayers().get(0).getWorker1().getPosition().getX();
                int wy1p1 = proxyModel.getPlayers().get(0).getWorker1().getPosition().getY();
                int wx2p1 = proxyModel.getPlayers().get(0).getWorker2().getPosition().getX();
                int wy2p1 = proxyModel.getPlayers().get(0).getWorker2().getPosition().getY();

                g.drawImage(img1, firstCellX - (firstCellX/2) + shift * wx1p1, firstCellY - (firstCellY / 2) + shift * wy1p1, firstCellX, firstCellY, null);
                g.drawImage(img1, firstCellX - (firstCellX/2)  + shift * wx2p1, firstCellY - (firstCellY / 2) + shift * wy2p1, firstCellY, firstCellY, null);
            }

            if (proxyModel.getPlayers().size() > 1 && proxyModel.getPlayers().get(1).getWorker1() != null) {
                int wx1p2 = proxyModel.getPlayers().get(1).getWorker1().getPosition().getX();
                int wy1p2 = proxyModel.getPlayers().get(1).getWorker1().getPosition().getY();
                int wx2p2 = proxyModel.getPlayers().get(1).getWorker2().getPosition().getX();
                int wy2p2 = proxyModel.getPlayers().get(1).getWorker2().getPosition().getY();

                g.drawImage(img2, firstCellX - (firstCellX/2) + shift * wx1p2, firstCellY - (firstCellY / 2) + shift * wy1p2, firstCellX, firstCellY, null);
                g.drawImage(img2, firstCellX - (firstCellX/2)  + shift * wx2p2, firstCellY - (firstCellY / 2) + shift * wy2p2, firstCellY, firstCellY, null);
            }

            if (proxyModel.getPlayers().size() > 2 && proxyModel.getPlayers().get(2).getWorker1() != null) {
                int wx1p3 = proxyModel.getPlayers().get(2).getWorker1().getPosition().getX();
                int wy1p3 = proxyModel.getPlayers().get(2).getWorker1().getPosition().getY();
                int wx2p3 = proxyModel.getPlayers().get(2).getWorker2().getPosition().getX();
                int wy2p3 = proxyModel.getPlayers().get(2).getWorker2().getPosition().getY();

                g.drawImage(img8, firstCellX - (firstCellX/2) + shift * wx1p3, firstCellY - (firstCellY / 2) + shift * wy1p3, firstCellX, firstCellY, null);
                g.drawImage(img8, firstCellX - (firstCellX/2)  + shift * wx2p3, firstCellY - (firstCellY / 2) + shift * wy2p3, firstCellY, firstCellY, null);
            }

        g4.setColor(new Color(20, 20, 20));
        Font font = new Font("Serif", Font.PLAIN, 24);
        g4.setFont(font);
        g4.drawString(proxyModel.getThisClientNickname(), 15, 700);
        /* if(proxyModel.getThisClientNickname().equals(proxyModel.getTurn().getCurrentPlayer().getName())) {
            g4.drawString("("+proxyModel.getTurn().getCurrentPlayer().getGodCard().getName()+")", 15, 750);
        } else if(proxyModel.getThisClientNickname().equals(proxyModel.getTurn().getNextPlayer().getName())) {
            g4.drawString("("+proxyModel.getTurn().getNextPlayer().getGodCard().getName()+")", 15, 750);
        } else if(proxyModel.getThisClientNickname().equals(proxyModel.getTurn().getPreviousPlayer().getName())) {
            g4.drawString("("+proxyModel.getTurn().getPreviousPlayer().getGodCard().getName()+")", 15, 750);
        } */

        /* g.drawImage(img1, 322-(50/2), 114-(50/2), 50, 50, null);
        g.drawImage(img2, 322-(50/2)+80, 114-(50/2), 50, 50, null);
        g.drawImage(img1, 322-(50/2)+80*2, 114-(50/2)+80*3, 50, 50, null);
        g.drawImage(img2, 322-(50/2)+80*3, 114-(50/2), 50, 50, null); */
    }
    /**
     *text to give indications to select a worker
     * @param g
     */
    private void writeText1(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should select a worker.", 15, 640);
    }
    /**
     *text to give indications to move worker
     * @param g
     */
    private void writeText2(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should move the selected worker.", 15, 640);
    }
    /**
     *text to give indications to build block
     * @param g
     */
    private void writeText3(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should build a block.", 15, 640);
    }

    /**
     *text to give indications to place worker
     * @param g
     */
    private void writeText4(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should place his Workers.", 15, 640);
    }
     /**
     *writeText5=shows the choice to choose between yes or no, when the power of god can be used
     **/
    public void writeText5(Graphics g) {

        ProxyModel proxyModel = ProxyModel.instance();
        ClassLoader cl = this.getClass().getClassLoader();
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        Graphics2D g4 = (Graphics2D) g;

        InputStream url1 = cl.getResourceAsStream("yes.png");
        InputStream url2 = cl.getResourceAsStream("no.png");

        BufferedImage img1 = null;
        BufferedImage img2 = null;

        try {
            img1 = ImageIO.read(url1);
            img2 = ImageIO.read(url2);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        //Display.instance().setClicked(0);
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2dbutton = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName()+", "+getPrompt(), 15, 640);

        if(ProxyModel.instance().getTurn().getCurrentPlayer().getName().equals(ProxyModel.instance().getThisClientNickname())) {
            g.drawImage(img1, 150, 650, 100, 100, null);
            g.drawImage(img2, 350, 650, 100, 100, null);
            if (Display.instance().getButtonAnswer() == 1) {
                g.setColor(new Color(20, 150, 20, 200));
                g.fillArc(150, 650, 100, 100, 0, 360);
                g.setColor(new Color(200, 200, 200, 200));
                g.fillArc(350, 650, 100, 100, 0, 360);
            } else if (Display.instance().getButtonAnswer() == 2) {
                g.setColor(new Color(150, 20, 20, 200));
                g.fillArc(350, 650, 100, 100, 0, 360);
                g.setColor(new Color(200, 200, 200, 200));
                g.fillArc(150, 650, 100, 100, 0, 360);
            }
        }

    }
    /**
     * text that is shown when someone win the game
     * @param g
     */
    private void writeText6(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " won the game!", 15, 640);
    }

    /**
     * text that is shown when someone lost the game
     * @param g
     */
    private void writeText7(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " lost the game...", 15, 640);
    }


    private void writeText0(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName(), 15, 640);
    }

    private void writePrompt(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName(), 15, 640);
    }

}
