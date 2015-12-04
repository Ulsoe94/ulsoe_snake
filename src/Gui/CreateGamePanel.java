package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Ulso on 30/11/15.
 */
public class CreateGamePanel extends JPanel {


    private JLabel lblCreateGame;
    private JLabel lblEnterGameName;
    private JLabel lblEnterMovements;
    private JLabel lblBackground;
    private JButton btnCreateGame;
    private JButton btnBack;
    private JTextField JtxtGameName;
    private JTextField JtxtMovement;

    private String Movement;
    private String GameName;


    public CreateGamePanel() {
        setLayout(null);

        //Jlabels
        lblCreateGame = new JLabel("Create Game");
        lblCreateGame.setForeground(new Color(0, 200, 0));
        lblCreateGame.setFont(new Font("Raleway", Font.BOLD, 25));
        lblCreateGame.setBounds(20, 43, 400, 34);
        add(lblCreateGame);

        lblEnterGameName = new JLabel("Enter Game Name:");
        lblEnterGameName.setForeground(new Color(0, 200, 0));
        lblEnterGameName.setFont(new Font("Raleway", Font.PLAIN, 13));
        lblEnterGameName.setBounds(20, 175, 400, 34);
        add(lblEnterGameName);

        lblEnterMovements = new JLabel("Enter Movements:");
        lblEnterMovements.setForeground(new Color(0, 200, 0));
        lblEnterMovements.setFont(new Font("Raleway", Font.PLAIN, 13));
        lblEnterMovements.setBounds(20, 235, 400, 34);
        add(lblEnterMovements);


        //JButtons
        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBackground(Color.LIGHT_GRAY);
        btnCreateGame.setFont(new Font("Raleway", Font.PLAIN, 13));
        btnCreateGame.setBounds(20, 330, 170, 43);
        btnCreateGame.setActionCommand("Play Game");
        add(btnCreateGame);


        btnBack = new JButton("Back");
        btnBack.setBackground(Color.LIGHT_GRAY);
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Raleway", Font.BOLD, 12));
        btnBack.setBounds(20, 450, 150, 30);
        btnBack.setActionCommand("Back");
        add(btnBack);

        //JTextfields
        JtxtGameName = new JTextField();
        JtxtGameName.setFont(new Font("Raleway", Font.PLAIN, 13));
        JtxtGameName.setBounds(20, 200, 170, 30);
        JtxtGameName.setColumns(10);
        add(JtxtGameName);

        JtxtMovement = new JTextField();
        JtxtMovement.setFont(new Font("Raleway", Font.PLAIN, 13));
        JtxtMovement.setBounds(20, 260, 170, 30);
        JtxtMovement.setColumns(10);
        add(JtxtMovement);

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
public String getMovement() {
        Movement = JtxtMovement.getText();
        return Movement;
    }
    public String getGameName() {
        GameName = JtxtGameName.getText();
        return GameName;


    }



//action listeners for the buttons
    public void addActionListener (ActionListener l){
        btnCreateGame.addActionListener(l);
        btnCreateGame.setActionCommand("CreateGameBtn"); // adds actioncommand

        btnBack.addActionListener(l);
        btnBack.setActionCommand("BackBtn");
    }

}
