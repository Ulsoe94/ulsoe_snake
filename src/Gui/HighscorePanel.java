package Gui;

import SDK.Score;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Ulso on 23/11/15.
 */
public class HighscorePanel extends JPanel {


    private JLabel lblHighScore;


    private JButton btnBack;

    private JTable tblHighscore;


    public HighscorePanel() {
        setLayout(null);

        //labels
        lblHighScore = new JLabel("Game Menu");
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
        btnBack = new JButton("Back");
        btnBack.setBackground(Color.LIGHT_GRAY);
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Raleway", Font.BOLD, 12));
        btnBack.setBounds(20, 450, 150, 30);
        btnBack.setActionCommand("Back");
        add(btnBack);




    }
    public void addActionListener (ActionListener l){




        btnBack.addActionListener(l);
        btnBack.setActionCommand("BackBtn");


    }


    public void highScoreTable(Score[] scores) {
        DefaultTableModel model = (DefaultTableModel) tblHighscore.getModel();

        for(Score score : scores) {
            model.addRow(new Object[]{score.getUser().getUsername(), score.getScore()});
        }
    }

}

