package Logic;

/**
 * Created by Ulso on 23/11/15.
 */

import Gui.Screen;
import SDK.*;
import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Snake {


    private Screen screen;
    private User thisuser;
    private ServerConnection connection = new ServerConnection();


    public Snake() { //the constructor Snake

        screen = new Screen();
        screen.setVisible(true);
    }

    //method Run that adds ActionListeners for each panel
    public void run() {
        screen.getLoginPanel().addActionlistener(new LoginPanelActionListener());
        screen.getGameMenu().addActionListener(new GameMenuActionListener());
        screen.getPlayPanel().addActionListener(new PlayPanelActionListener());
        screen.getCreateGamePanel().addActionListener(new CreateGamePanelActionListener());
        screen.getJoinGamePanel().addActionListener(new JoinGamePanelActionListener());
        screen.getDeletePanel().addActionListener(new DeletePanelActionListener());
        screen.getHighscorePanel().addActionListener(new HighscorePanelActionListener());
        screen.getMovementPanel().addActionListener(new MovementPanelActionListener());
        screen.show(screen.LOGINPANEL);

    }
    // Class that implements actionListeners for LoginPanel
    private class LoginPanelActionListener implements ActionListener
    {
        boolean authenticated = false;

        public void actionPerformed(ActionEvent e) // a method that runs when a Jbuttom is activated
        {
            String cmd = e.getActionCommand(); // local string that saves actioncommand
            if (cmd.equals("LoginBtn"));
            {
                String username = screen.getLoginPanel().getUsername(); //Gets the entered Username from loginpanel
                String password = screen.getLoginPanel().getPassword(); //Gets the entered Password from loginpanel

                thisuser = new User(); //
                thisuser.setUsername(username);
                thisuser.setPassword(password);

                String json = new Gson().toJson(thisuser);

                ServerConnection con = new ServerConnection();
                ClientResponse response = con.post(json, "login");

                if (response.getStatus() == 200) { //If server response is 200

                    authenticated = true; //authentication is set to true
                    System.out.println("User validated");
                    JOptionPane.showMessageDialog(screen, "Successful Login");
                    screen.show(Screen.GAMEMENU);

                }
                if (response.getStatus() == 500) { //if server reponse is 500

                    authenticated = false; //authenication is set to false
                    System.out.println("Bad request");
                    JOptionPane.showMessageDialog(screen, "Please sumbit both Email and password", "Error", JOptionPane.ERROR_MESSAGE);
                    screen.show(Screen.LOGINPANEL);
                }
                if (response.getStatus() == 400) { //if server respons is 400

                    authenticated = false; //authentication is set to false
                    System.out.println("Unauthorized");
                    JOptionPane.showMessageDialog(screen, "You have entered either a wrong username og password. Please try again", "Error", JOptionPane.ERROR_MESSAGE);
                    screen.show(Screen.LOGINPANEL);

                }


            }

        }
    } // method ends

    private class GameMenuActionListener implements ActionListener // class that has actionlistener
    {
        public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
        {
            String cmd = e.getActionCommand(); // local string that saves actioncommand

            if (cmd.equals("PlayBtn")) // if actioncommand is "PlayPanelBtn"
            {
                screen.getPlayPanel();
                screen.show(Screen.PLAYPANEL); // PlayPanel is in the window
            } // if ends
            if (cmd.equals("DeletePanelBtn")) // if actioncommand is "DeleteGameBtn"
            {
                screen.getDeletePanel();
                screen.show(Screen.DELETEPANEL); // insertspanel sets in the window
            } // if slutter
            if (cmd.equals("HighscoreBtn")) // if action command is "HighScoreBtn"
            {
                screen.getHighscorePanel();
                screen.show(Screen.HIGHSCOREPANEL); // Highscore sets in the window

            } // if ends
            if (cmd.equals("LogOutBtn")) // if actioncommand is "LogOutBtn"
            {

                screen.getLoginPanel(); //
                screen.show(Screen.LOGINPANEL); // loginpanel sets in the window
            } // if ends
        } // Method ends
    } // class ends.


    private class PlayPanelActionListener implements ActionListener // class that has actionlistener
    {
        public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
        {
            String cmd = e.getActionCommand();

            if (cmd.equals("JoinGameBtn")) // if actioncommand is "JoinGameBtn"
            {
                screen.getJoinGamePanel();
                screen.show(Screen.JOINGAMEPANEL);

            }
            if (cmd.equals("CreateGameBtn")) // if actioncommand is "CreateGameBtn"
            {
                screen.getCreateGamePanel();
                screen.show(Screen.CREATEGAMEPANEL);
            } else if (cmd.equals("BackBtn")) // if actioncommand is "BackBtn"
            {

                screen.getGameMenu();
                screen.show(Screen.GAMEMENU); // GameMenu sets in the window
            } // if ends
        } // Method ends
    } // class ends.


    private class CreateGamePanelActionListener implements ActionListener // class that has actionlistener
    {
        public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
        {
            String cmd = e.getActionCommand(); // local string that saves actioncommand

            if (cmd.equals("CreateGameBtn")) // if actioncommand is "CreateGame"
            {
                Gamer host = new Gamer(); //Sets host as new Gamer()
                host.setId(thisuser.getId()); //gets the thisuser's Id and sets it as the host
                host.setControls(screen.getCreateGamePanel().getMovement()); //Gets the movements and sets ii for the host

                Game game = new Game(); //sets game as new Game();
                game.setName(screen.getCreateGamePanel().getGameName()); //sets the game name from the txtfield.
                game.setHost(host); //sets the host as host.
                game.setMapSize(20); //sets the map size


                String data = new Gson().toJson(game); //String data

                ServerConnection con = new ServerConnection();
                ClientResponse response = con.post(data, "games"); //response gets requested to post to the server





                    if (response.getStatus() == 201) { //if the server response is 201
                    System.out.println("Game created"); //a game is created.

                    JOptionPane.showMessageDialog(screen, "Game " + game.getName() + " was created succesfully");
                    screen.getGameMenu();
                    screen.show(Screen.GAMEMENU);


                }
                if (response.getStatus() == 400) { //howeever if its 400
                    System.out.println("Something went wrong"); //shit just gone bad!
                    JOptionPane.showMessageDialog(screen, "CALL 911 NOOOOOW!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);


                }

            } else if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
            {

                screen.getGameMenu(); // reset method runs and removes labels from userpanel
                screen.show(Screen.GAMEMENU); // loginpanel sets in the window
            } // if ends
        } // Method ends
    } // class ends.


    private class JoinGamePanelActionListener implements ActionListener // class that has actionlistener
    {
        public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
        {
            String cmd = e.getActionCommand(); // local string that saves actioncommand

            int gameID = screen.getJoinGamePanel().getGameID();


            Gamer opponent = new Gamer();
            opponent.setId(1);

            Game game = new Game();
            game.setOpponent(opponent);
            game.setGameId(gameID);


            if (cmd.equals("ProceedBtn")) // if actioncommand is "PlayPanelBtn"
            {
                boolean join = connection.joinGame(game);

                if (join) {
                    screen.getMovementPanel();
                    screen.show(Screen.MOVEMENTPANEL);
                    JOptionPane.showMessageDialog(screen, "succesfully joined: Game " + gameID);

                }

                // Method ends
                else if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
                {

                    screen.getGameMenu(); // reset method runs and removes labels from userpanel
                    screen.show(Screen.GAMEMENU); // loginpanel sets in the window
                } // if ends
                // class ends.
            }
        }
    }
        private class MovementPanelActionListener implements ActionListener // class that has actionlistener
        {
            public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
            {

                int gameID = screen.getJoinGamePanel().getGameID(); //int GameID that gets the Gameid
                Gamer opponent = new Gamer();
                opponent.setControls(screen.getMovementPanel().getMovement()); //sets opponent controls

                Game game = new Game();
                game.setOpponent(opponent); //sets opponent
                game.setGameId(gameID); //sets GameId

                String cmd = e.getActionCommand(); // local string that saves actioncommand

                if (cmd.equals("JoinGameBtn")) // if actioncommand is "JoinGameBtn"
                {
                    connection.startGame(game);
                    screen.show(Screen.GAMEMENU);
                }

                if (cmd.equals("BackBtn")) // if actioncommand is "BackBtn"
                {

                    screen.getGameMenu(); // reset method runs and removes labels from userpanel
                    screen.show(Screen.GAMEMENU); // loginpanel sets in the window
                } // if ends
            } // Method ends
            // class ends.
        }

        private class DeletePanelActionListener implements ActionListener // class that has actionlistener
        {
            public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
            {
                String cmd = e.getActionCommand(); // local string that saves actioncommand

                if (cmd.equals("DeleteGameBtn")) // if actioncommand is "PlayPanelBtn"
                {
                    String gameId = screen.getDeletePanel().getGameID();

                    boolean success = connection.deleteGame(gameId); //boolean succes
                    if (success) {
                        JOptionPane.showMessageDialog(screen, "Game " + gameId + " was deleted succesfully");
                    } else {
                        JOptionPane.showMessageDialog(screen, "Game " + gameId + " could not be delete. Please try again." ,"Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
                {

                    screen.getGameMenu(); // reset method runs and removes labels from userpanel
                    screen.show(Screen.GAMEMENU); // loginpanel sets in the window
                } // if ends
            } // Method ends
        } // class ends.


        private class HighscorePanelActionListener implements ActionListener // class that has actionlistener
        {
            public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
            {
                String cmd = e.getActionCommand(); // local string that saves actioncommand
                if (cmd.equals("RefreshBtn")) {

                    screen.getHighscorePanel().clearHighscore();
                    Score[] highScores = connection.Highscore();

                    screen.getHighscorePanel();
                    screen.show(Screen.HIGHSCOREPANEL); // Highscore sets in the window
                    screen.getHighscorePanel().highScoreTable(highScores);


                }

                if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
                {
                    screen.getHighscorePanel().clearHighscore();
                    screen.getGameMenu(); // reset method runs and removes labels from userpanel
                    screen.show(Screen.GAMEMENU); // loginpanel sets in the window
                } // if ends
            } // Method ends
        } // class ends
    }

















