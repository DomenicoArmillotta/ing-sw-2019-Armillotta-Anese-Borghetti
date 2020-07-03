package it.polimi.ingsw.client.proxymodel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * BoardPanel is an extension of Java Swing's JPanel used to draw the game's board and prompts in the graphic client
 */

public class BoardPanel extends JPanel {


    ProxyModel proxyModel = ProxyModel.instance();
    private static final String mapFileName = "grid";
    private static final String pawnFileName = "pawn";
    private static final String blockFileName = "block";
    private static final String graphicExtension = ".png";
    private static final int mapWidth = 600;
    private static final int mapHeight = 600;
    private static final int firstCellX = 64;
    private static final int firstCellY = 64;
    private static final int shift = 118;
    /* First cell center: 322 114 */

    /**
     * getPrompt calls the getPromptText method of the Display class
     * @return a String that contains the textual prompt to display in the current game phase
     */

    public String getPrompt() {
        Display display = Display.instance();
        return display.getPromptText();
    }

    /**
     * setPrompt passes a String as a parameter to the setPrompt method of the Display class
     * @param promptText the prompt text
     */

    public void setPrompt(String promptText) {
        Display display = Display.instance();
        display.setPrompt(promptText);
    }

    /**
     * getPrompt calls the getCommandFailure method of the Display class
     * @return a String that contains the textual prompt to display in the current game phase
     */

    public String getCommandFailure() {
        Display display = Display.instance();
        return display.getCommandFailure();
    }

    /**
     * setPrompt passes a String as a parameter to the setCommandFailure method of the Display class
     * @param promptText the prompt text
     */

    public void setCommandFailure(String promptText) {
        Display display = Display.instance();
        display.setCommandFailure(promptText);
    }

    /**
     * getGraphicsFlag returns an integer number which is associated with the textual prompt to display,
     * it is found in the Display class
     * @return an integer graphicsFlag
     */

    public int getGraphicsFlag() {
        Display display = Display.instance();
        return display.getGraphicsFlag();
    }

    /**
     * setGraphicsFlag assigns an integer value to the graphicsFlag attribute of the Display class
     * @param graphicsFlag graphic flag
     */

    public void setGraphicsFlag(int graphicsFlag) {
        Display display = Display.instance();
        display.setGraphicsFlag(graphicsFlag);
    }

    /**
     * This methods overrides the paintComponent method of Java Swing's JPanel
     * for each graphicsFlag a different method is called to show a different text
     * @param g is used for paint component and derive by override
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g);

        switch(getGraphicsFlag()) {
            case 1: writeTextSelect(g);
                break;
            case 2: writeTextMove(g);
                break;
            case 3: writeTextBuild(g);
                break;
            case 4: writeTextPlaceWorkers(g);
                break;
            case 5: writeTextButtons(g);
                break;
            case 6: writeTextWin(g);
                break;
            case 7: writeTextLose(g);
                break;
            case 8: writeTextFailure(g);
                break;
            case 0: writeTextTurn(g);
                break;
        }
    }

    /**
     * drawImage shows every graphic aspect of the Client's GUI, such as pawns, blocks and the map
     * @param g is used for paint component and derive by override
     */

    private void drawImage(Graphics g) {
        ClassLoader cl = this.getClass().getClassLoader();
        Graphics2D g2d = (Graphics2D) g;

        InputStream urlPawns[] = new InputStream[3];
        for(int i = 0; i < 3; i++) {
            urlPawns[i] = cl.getResourceAsStream(pawnFileName+(i+1)+graphicExtension);
        }

        InputStream urlBlocks[] = new InputStream[4];
        for(int i = 0; i < 4; i++) {
            urlBlocks[i] = cl.getResourceAsStream(blockFileName+(i+1)+graphicExtension);
        }

        InputStream urlMap = cl.getResourceAsStream(mapFileName+graphicExtension);

        BufferedImage imagePawns[] = new BufferedImage[3];
        for(int i = 0; i < 3; i++) {
            imagePawns[i] = null;
        }

        BufferedImage imageBlocks[] = new BufferedImage[4];
        for(int i = 0; i < 4; i++) {
            imageBlocks[i] = null;
        }

        BufferedImage imageMap = null;

        try {
            for(int i = 0; i < 3; i++) {
                imagePawns[i] = ImageIO.read(urlPawns[i]);
            }
            for(int i = 0; i < 4; i++) {
                imageBlocks[i] = ImageIO.read(urlBlocks[i]);
            }
            imageMap = ImageIO.read(urlMap);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        g2d.drawImage(imageMap, 0, 0, mapWidth, mapHeight, null);

        ClientCell[][] map = proxyModel.getMap();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                switch (map[i][j].getLevel()) {
                    case 1:
                        g2d.drawImage(imageBlocks[0], 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                        break;
                    case 2:
                        g2d.drawImage(imageBlocks[1], 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                        break;
                    case 3:
                        g2d.drawImage(imageBlocks[2], 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                        break;
                    case 4:
                        g2d.drawImage(imageBlocks[3], 10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20, null);
                        break;
                    default:
                        break;
                }
                if (map[i][j].getSelectable() == 1) {
                    g2d.setColor(new Color(255, 0, 0, 80));
                    g2d.fillRect(10+firstCellX - firstCellX + shift * i, 10+firstCellY - firstCellY + shift * j, firstCellX*2-20, firstCellY*2-20);
                }
            }

        if (proxyModel.getPlayers().size() > 1 && proxyModel.getPlayers().get(0).getWorker1() != null) {
            int wx1p1 = proxyModel.getPlayers().get(0).getWorker1().getPosition().getX();
            int wy1p1 = proxyModel.getPlayers().get(0).getWorker1().getPosition().getY();
            int wx2p1 = proxyModel.getPlayers().get(0).getWorker2().getPosition().getX();
            int wy2p1 = proxyModel.getPlayers().get(0).getWorker2().getPosition().getY();

            g2d.drawImage(imagePawns[0], firstCellX - (firstCellX/2) + shift * wx1p1, firstCellY - (firstCellY / 2) + shift * wy1p1, firstCellX, firstCellY, null);
            g2d.drawImage(imagePawns[0], firstCellX - (firstCellX/2)  + shift * wx2p1, firstCellY - (firstCellY / 2) + shift * wy2p1, firstCellY, firstCellY, null);
        }

        if (proxyModel.getPlayers().size() > 1 && proxyModel.getPlayers().get(1).getWorker1() != null) {
            int wx1p2 = proxyModel.getPlayers().get(1).getWorker1().getPosition().getX();
            int wy1p2 = proxyModel.getPlayers().get(1).getWorker1().getPosition().getY();
            int wx2p2 = proxyModel.getPlayers().get(1).getWorker2().getPosition().getX();
            int wy2p2 = proxyModel.getPlayers().get(1).getWorker2().getPosition().getY();

            g2d.drawImage(imagePawns[1], firstCellX - (firstCellX/2) + shift * wx1p2, firstCellY - (firstCellY / 2) + shift * wy1p2, firstCellX, firstCellY, null);
            g2d.drawImage(imagePawns[1], firstCellX - (firstCellX/2)  + shift * wx2p2, firstCellY - (firstCellY / 2) + shift * wy2p2, firstCellY, firstCellY, null);
        }

        if (proxyModel.getPlayers().size() > 2 && proxyModel.getPlayers().get(2).getWorker1() != null) {
            int wx1p3 = proxyModel.getPlayers().get(2).getWorker1().getPosition().getX();
            int wy1p3 = proxyModel.getPlayers().get(2).getWorker1().getPosition().getY();
            int wx2p3 = proxyModel.getPlayers().get(2).getWorker2().getPosition().getX();
            int wy2p3 = proxyModel.getPlayers().get(2).getWorker2().getPosition().getY();

            g2d.drawImage(imagePawns[2], firstCellX - (firstCellX/2) + shift * wx1p3, firstCellY - (firstCellY / 2) + shift * wy1p3, firstCellX, firstCellY, null);
            g2d.drawImage(imagePawns[2], firstCellX - (firstCellX/2)  + shift * wx2p3, firstCellY - (firstCellY / 2) + shift * wy2p3, firstCellY, firstCellY, null);
        }

        g2d.setColor(new Color(20, 20, 20));
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setFont(font);
        g2d.drawString(proxyModel.getThisClientNickname(), 15, 700);
    }

    /**
     * writeTextSelect shows the textual prompt for the selection phase
     * @param g is used for paint component and derive by override
     */

    private void writeTextSelect(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should select a worker.", 15, 640);
    }

    /**
     * writeTextMove shows the textual prompt for the move phase
     * @param g is used for paint component and derive by override
     */

    private void writeTextMove(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should move the selected worker.", 15, 640);
    }

    /**
     * writeTextBuild shows the textual prompt for the build phase
     * @param g is used for paint component and derive by override
     */

    private void writeTextBuild(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should build a block.", 15, 640);
    }

    /**
     * writeTextPlaceWorkers shows the textual prompt for the workers' setup phase
     * @param g is used for paint component and derive by override
     */

    private void writeTextPlaceWorkers(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " should place his Workers.", 15, 640);
    }

    /**
     * writeTextButtons show the textual prompt for the prompt's answer phase
     * @param g is used for paint component and derive by override
     */

    public void writeTextFailure(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(Display.instance().getCommandFailure(), 15, 640);


    }

    public void writeTextButtons(Graphics g) {
        ClassLoader cl = this.getClass().getClassLoader();

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

        Graphics2D g2d = (Graphics2D) g;
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
     * writeTextButtons show the textual prompt for the win phase
     * @param g is used for paint component and derive by override
     */

    private void writeTextWin(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " won the game!", 15, 640);
    }

    /**
     * writeTextButtons show the textual prompt for the lose phase
     * @param g is used for paint component and derive by override
     */

    private void writeTextLose(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName() + " lost the game...", 15, 640);
    }

    /**
     * writeTextTurn show the textual prompt for any other phase
     * @param g is used for paint component and derive by override
     */

    private void writeTextTurn(Graphics g) {
        ProxyModel proxyModel = ProxyModel.instance();
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2d.setColor(new Color(20, 20, 20));
        g2d.setFont(font);
        g2d.drawString(proxyModel.getTurn().getCurrentPlayer().getName(), 15, 640);
    }

}
