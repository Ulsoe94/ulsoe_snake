package Gui;

/**
 * Created by Ulso on 23/11/15.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Ulso on 19/11/15.
 */
public class GameMenu extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton btnPlayGame;
    private JButton btnDeletePanel;
    private JButton btnSeeHighscore;
    private JButton btnLogOut;
    private JLabel lblWelcomeUser;
    private JLabel lblBackground;


    public GameMenu() {
        setLayout(null);

        btnPlayGame = new JButton("Play Game");
        btnPlayGame.setBackground(Color.LIGHT_GRAY);
        btnPlayGame.setFont(new Font("Raleway", Font.PLAIN, 13));
        btnPlayGame.setBounds(20, 230, 200, 43);
        btnPlayGame.setActionCommand("Play Game");
        add(btnPlayGame);

        btnDeletePanel = new JButton("Delete Game");
        btnDeletePanel.setBackground(Color.LIGHT_GRAY);
        btnDeletePanel.setFont(new Font("Raleway", Font.PLAIN, 13));
        btnDeletePanel.setBounds(20, 280, 200, 43);
        btnDeletePanel.setActionCommand("Delete Panel");
        add(btnDeletePanel);

        btnSeeHighscore = new JButton("See Highscore");
        btnSeeHighscore.setBackground(Color.LIGHT_GRAY);
        btnSeeHighscore.setFont(new Font("Raleway", Font.PLAIN, 13));
        btnSeeHighscore.setBounds(20, 330, 200, 43);
        btnSeeHighscore.setActionCommand("See Highscore");
        add(btnSeeHighscore);



        btnLogOut = new JButton("Log out");
        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLogOut.setBackground(Color.LIGHT_GRAY);
        btnLogOut.setForeground(new Color(0, 0, 0));
        btnLogOut.setFont(new Font("Raleway", Font.BOLD, 12));
        btnLogOut.setBounds(20, 450, 150, 30);
        btnLogOut.setActionCommand("Log out");
        add(btnLogOut);

        lblWelcomeUser = new JLabel("Game Menu");
        lblWelcomeUser.setFont(new Font("Raleway", Font.BOLD, 20));
        lblWelcomeUser.setForeground(new Color(0, 200, 0));
        lblWelcomeUser.setBounds(20, 34, 400, 35);
        add(lblWelcomeUser);

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
        btnPlayGame.addActionListener(l);
        btnPlayGame.setActionCommand("PlayBtn"); // adds actioncommand
        btnDeletePanel.addActionListener(l);
        btnDeletePanel.setActionCommand("DeletePanelBtn");
        btnSeeHighscore.addActionListener(l);
        btnSeeHighscore.setActionCommand("SeeHighscoreBtn");
        btnLogOut.addActionListener(l);
        btnLogOut.setActionCommand("LogOutBtn");
    }

}
