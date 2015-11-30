package Gui;

/**
 * Created by Ulso on 23/11/15.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Screen extends JFrame // Gui.Screen class that extender JFrame
{
    // instance variable
    private static final long serialVersionUID = 1L; // generated ID

    //final static Strings
    public static final String ADMINADD = "1";
    public static final String ADMINEDIT = "2";
    public static final String ADMINSIDE = "3";
    public static final String LOGINPANEL = "4";
    public static final String CREATEGAMEPANEL = "5";
    public static final String GAMEMENU = "6";
    public static final String DELETEPANEL = "7";
    public static final String PLAYPANEL = "8";
    public static final String HIGHSCORE = "9";
    public static final String JOINGAMEPANEL = "10";


    // Variables
    private JPanel contentPane;

    private LoginPanel loginPanel;
    private GameMenu gameMenu;
    private PlayPanel playPanel;
    private Highscore highscore;
    private DeletePanel deletePanel;
    private CreateGamePanel createGamePanel;
    private JoinGamePanel joinGamePanel;


    CardLayout c; //variabel for cardlayout

    /**
     * Constructer that holds the frame and an object for every panel
     */
    public Screen() {
        setTitle("Snake@CBS"); // title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program is shut down and the window closes
        setBounds(200, 200, 500, 519); // size of the window
        contentPane = new JPanel(); // empty panel is created
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // size of the window
        setContentPane(contentPane); // empty panel is placed in the window
        contentPane.setLayout(new CardLayout(0, 0)); // panel layout is set to cardlayout


        loginPanel = new LoginPanel();
        contentPane.add(loginPanel, LOGINPANEL);

        gameMenu = new GameMenu();
        contentPane.add(gameMenu, GAMEMENU);

        playPanel = new PlayPanel();
        contentPane.add(playPanel, PLAYPANEL);

        joinGamePanel = new JoinGamePanel();
        contentPane.add(joinGamePanel, JOINGAMEPANEL);

        createGamePanel = new CreateGamePanel();
        contentPane.add(createGamePanel, CREATEGAMEPANEL);

        deletePanel = new DeletePanel();
        contentPane.add(deletePanel, DELETEPANEL);

        highscore = new Highscore();
        //contentPane.add(highscore, HIGHSCORE);


        c = (CardLayout) getContentPane().getLayout(); // cardlayoutet is set to contain of the different contentpanes
    } // constructor ends


    // getters and setters


    /**
     * @return loginSide
     */
    public LoginPanel getLoginPanel() { return loginPanel; // returns loginPanel
    }

    public GameMenu getGameMenu() { return gameMenu;
    }

    public PlayPanel getPlayPanel() {
        return playPanel;
    }

    public CreateGamePanel getCreateGamePanel() { return createGamePanel; }

    public JoinGamePanel getJoinGamePanel() { return joinGamePanel; }

    public DeletePanel getDeletePanel() {
        return deletePanel;
    }

    public Highscore getHighscore() {
        return highscore;
    }

    /**
     * @param card
     */
    public void show(String card) // method to shift between the different panels with cardlayout
    {
        c.show(getContentPane(), card); // cardlayout shiws the contentpane that it recieves


    } // method ends
}



