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
public class PlayPanel extends JLabel {

    private JButton btnCreateGame;
    private JButton btnJoinGame;;
    private JButton btnBack;
    private JLabel lblPlayPanel;
    private JLabel lblBackground;



    public PlayPanel() {
        setLayout(null);


        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBackground(Color.LIGHT_GRAY);
        btnCreateGame.setFont(new Font("Raleway", Font.PLAIN, 13));
        btnCreateGame.setBounds(20, 230, 200, 43);
        btnCreateGame.setActionCommand("Play Game");
        add(btnCreateGame);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setBackground(Color.LIGHT_GRAY);
        btnJoinGame.setFont(new Font("Raleway", Font.PLAIN, 13));
        btnJoinGame.setBounds(20, 280, 200, 43);
        btnJoinGame.setActionCommand("Delete Panel");
        add(btnJoinGame);



        btnBack = new JButton("back");
        btnBack.setBackground(Color.LIGHT_GRAY);
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Raleway", Font.BOLD, 12));
        btnBack.setBounds(20, 450, 150, 30);
        btnBack.setActionCommand("Back");
        add(btnBack);

        lblPlayPanel = new JLabel("Game Menu");
        lblPlayPanel.setFont(new Font("Raleway", Font.BOLD, 20));
        lblPlayPanel.setForeground(new Color(0, 200, 0));
        lblPlayPanel.setBounds(20, 34, 400, 35);
        add(lblPlayPanel);

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

    public void addActionListener(ActionListener l){
        btnJoinGame.addActionListener(l);
        btnJoinGame.setActionCommand("JoinGameBtn"); // adds actioncommand
        btnCreateGame.addActionListener(l);
        btnCreateGame.setActionCommand("CreateGameBtn");
        btnBack.addActionListener(l);
        btnBack.setActionCommand("BackBtn");
    }

}






