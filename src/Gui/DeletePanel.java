package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Ulso on 23/11/15.
 */

    /**
     * Created by Ulso on 20/11/15.
     */
    public class DeletePanel extends JPanel {

        private JLabel lblDeletePanel;
        private JLabel lblEnterGameID;
        private JTextField gameID;
        private JLabel lblBackground;
        private JButton btnDeleteGame;
        private JButton btnBack;


        public DeletePanel() {
            setLayout(null);

            //JLabels
            lblDeletePanel = new JLabel("Delete Panel");
            lblDeletePanel.setForeground(new Color(0, 200, 0));
            lblDeletePanel.setFont(new Font("Raleway", Font.BOLD, 20));
            lblDeletePanel.setBounds(20, 34, 400, 35);
            add(lblDeletePanel);

            lblEnterGameID = new JLabel("Enter GameID");
            lblEnterGameID.setForeground(new Color(0, 200, 0));
            lblEnterGameID.setFont(new Font("Raleway", Font.BOLD, 15));
            lblEnterGameID.setBounds(70, 220, 400, 100);
            add(lblEnterGameID);

            //JTextfields
            gameID = new JTextField();
            gameID.setFont(new Font("Raleway", Font.PLAIN, 13));
            gameID.setBounds(20, 280, 200, 34);
            gameID.setColumns(10);
            add(gameID);

            //JButtons
            btnDeleteGame = new JButton("Delete game");
            btnDeleteGame.setFont(new Font("Raleway", Font.PLAIN, 17));
            btnDeleteGame.setForeground(new Color(0, 0, 0));
            btnDeleteGame.setBackground(Color.LIGHT_GRAY);
            btnDeleteGame.setBounds(20, 330, 200, 43);
            btnDeleteGame.setActionCommand("DeleteGame");
            add(btnDeleteGame);

            btnBack = new JButton("Back");
            btnBack.setFont(new Font("Raleway", Font.PLAIN, 15));
            btnBack.setForeground(new Color(0, 0, 0));
            btnBack.setBackground(Color.LIGHT_GRAY);
            btnBack.setBounds(20, 450, 150, 30);
            add(btnBack);



            try // tries to load image
            {
                BufferedImage img = ImageIO.read(this.getClass().getResource("/Pictures/Snakes-fangs.jpg")); // loads image from package image images
                lblBackground = new JLabel(""); // creates label without text
                lblBackground.setIcon(new ImageIcon(img)); // sets label icon to the loaded image
                lblBackground.setBounds(0, 0, 500, 510); // sets background size
                add(lblBackground); // adds panel
            } // try ends
            catch (IOException ex) {
            }
        }

        //getters
        public String getGameID()
        {
            return gameID.getText();

        }

        //action listeners for the buttons
        public void addActionListener(ActionListener l) {
            btnDeleteGame.addActionListener(l);
            btnDeleteGame.setActionCommand("DeleteGameBtn"); // adds actioncommand
            btnBack.addActionListener(l);
            btnBack.setActionCommand("BackBtn");
        }






    }







