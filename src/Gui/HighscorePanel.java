package Gui;

import SDK.Score;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Ulso on 23/11/15.
 */
public class HighscorePanel extends JPanel {


    private JLabel lblHighScore;
    private JLabel lblBackground;
    private JButton btnBack;
    private JButton btnRefresh;
    private JTable tblHighscore;


    public HighscorePanel() {
        setLayout(null);

        //Jlabels
        lblHighScore = new JLabel("Highscore");
        lblHighScore.setFont(new Font("Raleway", Font.BOLD, 20));
        lblHighScore.setForeground(new Color(0, 200, 0));
        lblHighScore.setBounds(20, 34, 400, 35);
        add(lblHighScore);



        //table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 400, 300);
        add(scrollPane);

        tblHighscore = new JTable(new DefaultTableModel(new Object[]{"username", "score"}, 0));
        scrollPane.setViewportView(tblHighscore);



        //Jbuttons
        btnRefresh = new JButton("Refresh");
        btnRefresh.setBackground(Color.LIGHT_GRAY);
        btnRefresh.setForeground(new Color(0, 0, 0));
        btnRefresh.setFont(new Font("Raleway", Font.BOLD, 12));
        btnRefresh.setBounds(20, 400, 150, 30);
        btnRefresh.setActionCommand("RefreshBtn");
        add(btnRefresh);



        btnBack = new JButton("Back");
        btnBack.setBackground(Color.LIGHT_GRAY);
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Raleway", Font.BOLD, 12));
        btnBack.setBounds(20, 450, 150, 30);
        btnBack.setActionCommand("Back");
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






    //actionslisteners
    public void addActionListener (ActionListener l){

        btnRefresh.addActionListener(l);
        btnRefresh.setActionCommand("RefreshBtn");

        btnBack.addActionListener(l);
        btnBack.setActionCommand("BackBtn");


    }

    //method that gets the information from the class Score and attachs it to the highscore table.
    public void highScoreTable(Score[] scores) {
        DefaultTableModel model = (DefaultTableModel) tblHighscore.getModel();

        for(Score score : scores) {
            model.addRow(new Object[]{score.getUser().getUsername(), score.getScore()});
        }
    }

    //method that clears the highscore panel for information.
    public void clearHighscore() {
       DefaultTableModel model = (DefaultTableModel) tblHighscore.getModel();
       model.setRowCount(0);

}




}

