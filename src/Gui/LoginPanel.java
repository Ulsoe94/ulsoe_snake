package Gui;

/**
 * Created by Ulso on 23/11/15.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class LoginPanel extends JPanel {

    private JLabel lblWelcomeToSnake;
    private JLabel lblPleaseEnterStudentid;
    private JLabel lblStudentid;
    private JLabel lblPassword;
    private JLabel lblBackground;
    private JLabel madeBy;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnLogin;


    public LoginPanel() {
        setLayout(null);

        //Jlabels
        lblWelcomeToSnake = new JLabel("Snake");
        lblWelcomeToSnake.setForeground(new Color(0, 200, 0));
        lblWelcomeToSnake.setFont(new Font("Raleway", Font.BOLD, 25));
        lblWelcomeToSnake.setBounds(20, 43, 400, 34);
        add(lblWelcomeToSnake);


        lblPleaseEnterStudentid = new JLabel("Please enter login info.");
        lblPleaseEnterStudentid.setForeground(new Color(0, 200, 0));
        lblPleaseEnterStudentid.setFont(new Font("Raleway", Font.BOLD, 14));
        lblPleaseEnterStudentid.setBounds(20, 250, 400, 17);
        add(lblPleaseEnterStudentid);

        lblStudentid = new JLabel("CBS Email:");
        lblStudentid.setForeground(new Color(0, 200, 0));
        lblStudentid.setFont(new Font("Raleway", Font.PLAIN, 13));
        lblStudentid.setBounds(68, 300, 100, 14);
        add(lblStudentid);


        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(0, 200, 0));
        lblPassword.setFont(new Font("Raleway", Font.PLAIN, 13));
        lblPassword.setBounds(68, 360, 70, 14);
        add(lblPassword);


        //textfield
        username = new JTextField();
        username.setFont(new Font("Raleway", Font.PLAIN, 13));
        username.setBounds(20, 320, 170, 30);
        username.setColumns(10);
        add(username);


        //passwordfield
        passwordField = new JPasswordField();
        passwordField.setBounds(20, 380, 170, 30);
        add(passwordField);


        //Jbuttom
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Raleway", Font.BOLD, 17));
        btnLogin.setForeground(new Color(0, 0, 0));
        btnLogin.setBounds(20, 430, 170, 43);
        btnLogin.setActionCommand("Login");
        add(btnLogin);


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


        //adds music to the background

       /** try {
            File file = new File("/Users/Ulso/Documents/window builder/src/Pictures/Bam.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }*/
    }


    //Actionlisteners
    public void addActionlistener(ActionListener l) {
        btnLogin.addActionListener(l); // adds actionlistener
        btnLogin.setActionCommand("LoginBtn"); // adds actioncommand
        btnLogin.getRootPane().setDefaultButton(btnLogin);

    }


    // getters
    public String getUsername()

    {
        return username.getText();

    }

    public String getPassword() {


        return passwordField.getText();
    }



}



