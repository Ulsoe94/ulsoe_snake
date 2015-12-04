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
public class JoinGamePanel extends JPanel {

    private JLabel lblJoinGamePanel;
    private JLabel lblEnterGameID;
    //private JLabel lblEnterMovement;
    private JLabel lblBackground;
    private JTextField txtGameID;
   // private JTextField txtMovement;
    private JButton btnProceed;
    private JButton btnBack;


public JoinGamePanel() {
    setLayout(null);

    //Jlabels
    lblJoinGamePanel = new JLabel("Join Game");
    lblJoinGamePanel.setForeground(new Color(0, 200, 0));
    lblJoinGamePanel.setFont(new Font("Raleway", Font.BOLD, 25));
    lblJoinGamePanel.setBounds(20, 43, 400, 34);
    add(lblJoinGamePanel);

    lblEnterGameID = new JLabel("Enter Game ID:");
    lblEnterGameID.setForeground(new Color(0, 200, 0));
    lblEnterGameID.setFont(new Font("Raleway", Font.PLAIN, 13));
    lblEnterGameID.setBounds(20, 175, 400, 34);
    add(lblEnterGameID);

    /**lblEnterMovement = new JLabel("Enter Movement:");
     lblEnterMovement.setForeground(new Color(0, 200, 0));
     lblEnterMovement.setFont(new Font("Raleway", Font.PLAIN, 13));
     lblEnterMovement.setBounds(20, 235, 400, 34);
     add(lblEnterMovement);*/


    //JButtons
    btnProceed = new JButton("Proceed");
    btnProceed.setBackground(Color.LIGHT_GRAY);
    btnProceed.setFont(new Font("Raleway", Font.PLAIN, 13));
    btnProceed.setBounds(20, 330, 170, 43);
    btnProceed.setActionCommand("Proceed");
    add(btnProceed);

    btnBack = new JButton("Back");
    btnBack.setBackground(Color.LIGHT_GRAY);
    btnBack.setForeground(new Color(0, 0, 0));
    btnBack.setFont(new Font("Raleway", Font.BOLD, 12));
    btnBack.setBounds(20, 450, 150, 30);
    btnBack.setActionCommand("Back");
    add(btnBack);


    //JTextfields
    txtGameID = new JTextField();
    txtGameID.setFont(new Font("Raleway", Font.PLAIN, 13));
    txtGameID.setBounds(20, 200, 170, 30);
    txtGameID.setColumns(10);
    add(txtGameID);

    /**txtMovement = new JTextField();
     txtMovement.setFont(new Font("Raleway", Font.PLAIN, 13));
     txtMovement.setBounds(20, 260, 170, 30);
     txtMovement.setColumns(10);
     add(txtMovement);*/

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


public int getGameID() {
        int gameID = Integer.parseInt(txtGameID.getText());
        return gameID;
    }




    //Actionlisteners
    public void addActionListener (ActionListener l){
        btnProceed.addActionListener(l);
        btnProceed.setActionCommand("ProceedBtn"); // adds actioncommand

        btnBack.addActionListener(l);
        btnBack.setActionCommand("BackBtn");
    }





}
