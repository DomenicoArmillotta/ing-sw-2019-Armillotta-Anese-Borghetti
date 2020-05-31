package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.server.virtualview.listeners.Listener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class SwingFirstExample {

    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("LOGIN");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific
         * positions in a JFrame. Inside panels we can add text
         * fields, buttons and other components.
         */
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
        placeComponents(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        ActionListener actionListener1= new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGame();
            }
        };
        /* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout
         * to null
         */
        panel.setLayout(null);

        // Creating JLabel
        JLabel userLabel = new JLabel("User Name");
        /* This method specifies the location and size
         * of component. setBounds(x, y, width, height)
         * here (x,y) are cordinates from the top left
         * corner and remaining two arguments are the width
         * and height of the component.
         */
        userLabel.setBounds(10,40,80,30);
        panel.add(userLabel);

        /* Creating text field where user is supposed to
         * enter user name.
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,40,165,25);
        panel.add(userText);

        // Creating login button
        final JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(120, 100, 80, 25);
        loginButton.setBackground(Color.lightGray);
        panel.add(loginButton);
        loginButton.addActionListener(actionListener1);
        }

        private static void createGame(){
            JFrame frame2 = new JFrame("GIOCO");
            // Setting the width and height of frame
            frame2.setSize(500, 500);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /* Creating panel. This is same as a div tag in HTML
             * We can create several panels and add them to specific
             * positions in a JFrame. Inside panels we can add text
             * fields, buttons and other components.
             */
            JPanel panel = new JPanel();
            panel.setBackground(Color.blue);
            // adding panel to frame
            frame2.add(panel);
            frame2.setVisible(true);
        }

    }


