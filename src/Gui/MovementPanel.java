package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Ulso on 04/12/15.
 */
public class MovementPanel extends JPanel {

    private JLabel lblMovmenetPanel;
    private JLabel lblEnterMovement;
    //private JLabel lblEnterMovement;
    private JLabel lblBackground;
    private JTextField txtMovement;
    // private JTextField txtMovement;
    private JButton btnJoinGame;
    private JButton btnBack;
    private String movement;




    public MovementPanel() {
        setLayout(null);

        //Jlabels
        lblMovmenetPanel = new JLabel("Movement");
        lblMovmenetPanel.setForeground(new Color(0, 200, 0));
        lblMovmenetPanel.setFont(new Font("Raleway", Font.BOLD, 25));
        lblMovmenetPanel.setBounds(20, 43, 400, 34);
        add(lblMovmenetPanel);

        lblMovmenetPanel = new JLabel("Enter your movement:");
        lblMovmenetPanel.setForeground(new Color(0, 200, 0));
        lblMovmenetPanel.setFont(new Font("Raleway", Font.PLAIN, 13));
        lblMovmenetPanel.setBounds(20, 175, 400, 34);
        add(lblMovmenetPanel);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setBackground(Color.LIGHT_GRAY);
        btnJoinGame.setFont(new Font("Raleway", Font.PLAIN, 13));
        btnJoinGame.setBounds(20, 330, 170, 43);
        btnJoinGame.setActionCommand("Join Game");
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBackground(Color.LIGHT_GRAY);
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Raleway", Font.BOLD, 12));
        btnBack.setBounds(20, 450, 150, 30);
        btnBack.setActionCommand("Back");
        add(btnBack);

        txtMovement = new JTextField();
        txtMovement.setFont(new Font("Raleway", Font.PLAIN, 13));
        txtMovement.setBounds(20, 200, 170, 30);
        txtMovement.setColumns(10);
        add(txtMovement);

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


public String getMovement() {
    movement = txtMovement.getText();
    return movement;
}




    public void addActionListener (ActionListener l){
        btnJoinGame.addActionListener(l);
        btnJoinGame.setActionCommand("JoinGameBtn"); // adds actioncommand

        btnBack.addActionListener(l);
        btnBack.setActionCommand("BackBtn");
    }


}




