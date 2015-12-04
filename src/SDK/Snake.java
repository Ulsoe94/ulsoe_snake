package SDK;

/**
 * Created by Ulso on 23/11/15.
 */

import Gui.Screen;
import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Snake {


    private Screen screen;
    private User thisuser;
    private ServerConnection connection = new ServerConnection();


    public Snake() {

        screen = new Screen();
        screen.setVisible(true);
    }


    public void run() {

        screen.getLoginPanel().addActionlistener(new LoginPanelActionListener());
        screen.getGameMenu().addActionListener(new GameMenuActionListener());
        screen.getPlayPanel().addActionListener(new PlayPanelActionListener());
        screen.getCreateGamePanel().addActionListener(new CreateGamePanelActionListener());
        screen.getJoinGamePanel().addActionListener(new JoinGamePanelActionListener());
        screen.getDeletePanel().addActionListener(new DeletePanelActionListener());
        screen.getHighscorePanel().addActionListener(new HighscorePanelActionListener());
        screen.show(screen.LOGINPANEL);

    }

    private class LoginPanelActionListener implements ActionListener // Class that implements actionListeners
    {
        boolean authenticated = false;

        public void actionPerformed(ActionEvent e) // a method that runs when a Jbuttom as activated in the login-panel
        {

            if (e.getSource() == screen.getLoginPanel().getBtnLogin()) {


                String username = screen.getLoginPanel().getUsername();
                String password = screen.getLoginPanel().getPassword();

                thisuser = new User();


                thisuser.setUsername(username);
                thisuser.setPassword(password);

                String json = new Gson().toJson(thisuser);

                ServerConnection con = new ServerConnection();
                ClientResponse response = con.post(json, "login");

                if (response.getStatus() == 200) {
                    authenticated = true;
                    System.out.println("User validated");
                    JOptionPane.showMessageDialog(screen, "Successful Login");
                    screen.show(Screen.GAMEMENU);

                }
                if (response.getStatus() == 500) {

                    authenticated = false;
                    System.out.println("Bad request");
                    JOptionPane.showMessageDialog(screen, "The request could not be understood by the server due to malformed syntax");
                    screen.show(Screen.LOGINPANEL);
                }
                if (response.getStatus() == 401) {

                    authenticated = false;
                    System.out.println("Unauthorized");
                    JOptionPane.showMessageDialog(screen, "User could not be authorized");
                    screen.show(Screen.LOGINPANEL);

                }


            }
            /**authenticateuser(); // runs the method authenticate user
             screen.getLoginSide().reset(); // resets labels at loginpanel

             if(userAuthenticated) // If a user is authorized
             {
             screen.getGameMenu().setName(dbconn.getFirstname(), dbconn.getLastname()); // Attach names on userpanel
             screen.show(Screen.GAMEMENU); // Attach userpanel in the window
             } // if slutter
             if(adminAuthenticated) // If an Admin is authorized
             {
             screen.getAdminSide().setRate(dbconn.getRate()); // Sets the rate
             screen.show(Screen.ADMINSIDE); // Attach adminpanel to the window
             } // if slutter
             if(recipientAuthenticated) // If the Recipent is authorized
             {
             screen.getRecipientSide().setName(dbconn.getRecipient()); // Sets name at RecipientPanel
             screen.show(Screen.RECIPIENTSIDE); // Attach recipentpanel in the window
             } // if slutter
             if(!adminAuthenticated && !userAuthenticated && !recipientAuthenticated) // If none of the usertypes are authorized
             {
             screen.getLoginPanel().incorrect(); // running the method incorrect
             } // if ends*/

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

                Score[] highScores = connection.getHighscore();

                screen.getHighscorePanel();
                screen.show(Screen.HIGHSCOREPANEL); // Highscore sets in the window

                screen.getHighscorePanel().highScoreTable(highScores);





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

            if (cmd.equals("JoinGameBtn")) // if actioncommand is "PlayPanelBtn"
            {
                screen.getJoinGamePanel();
                screen.show(Screen.JOINGAMEPANEL);

            }
            if (cmd.equals("CreateGameBtn")) // if actioncommand is "PlayPanelBtn"
            {
                screen.getCreateGamePanel();
                screen.show(Screen.CREATEGAMEPANEL);
            }
        }

    }

    private class CreateGamePanelActionListener implements ActionListener // class that has actionlistener
    {
        public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
        {
            String cmd = e.getActionCommand(); // local string that saves actioncommand

            if (cmd.equals("CreateGameBtn")) // if actioncommand is "PlayPanelBtn"
            {
                Gamer host = new Gamer();
                host.setId(thisuser.getId());
                host.setControls(screen.getCreateGamePanel().getMovement());

                Game game = new Game();
                game.setName(screen.getCreateGamePanel().getGameName());
                game.setHost(host);
                game.setMapSize(20);

                String json = new Gson().toJson(game);

                ServerConnection con = new ServerConnection();
                ClientResponse response = con.post(json, "games");

                if (response.getStatus() == 201) {
                    System.out.println("Game created");


                }
                if (response.getStatus() == 400) {
                    System.out.println("Something went wrong");

                }
                if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
                {
                    //userAuthenticated = false; // brugerauthorization sets false
                    screen.getGameMenu(); // reset method runs and removes labels from userpanel
                    screen.show(Screen.GAMEMENU); // loginpanel sets in the window
                } // if ends
            } // Method ends
        } // class ends.

    }

    private class JoinGamePanelActionListener implements ActionListener // class that has actionlistener
    {
        public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
        {
            String cmd = e.getActionCommand(); // local string that saves actioncommand

            if (cmd.equals("JoinGameBtn")) // if actioncommand is "PlayPanelBtn"
            {


                if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
                {

                    screen.getGameMenu(); // reset method runs and removes labels from userpanel
                    screen.show(Screen.GAMEMENU); // loginpanel sets in the window
                } // if ends
            } // Method ends
        } // class ends.
    }

        private class DeletePanelActionListener implements ActionListener // class that has actionlistener
        {
            public void actionPerformed(ActionEvent e) // method that runs when a button is pressed in the user panel
            {
                String cmd = e.getActionCommand(); // local string that saves actioncommand

                if (cmd.equals("DeleteGameBtn")) // if actioncommand is "PlayPanelBtn"
                {

                }

                if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
                {
                    //userAuthenticated = false; // brugerauthorization sets false
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




            if (cmd.equals("BackBtn")) // if actioncommand is "LogOutBtn"
            {
                //userAuthenticated = false; // brugerauthorization sets false
                screen.getGameMenu(); // reset method runs and removes labels from userpanel
                screen.show(Screen.GAMEMENU); // loginpanel sets in the window
            } // if ends
        } // Method ends
    } // class ends.


}

        /**if (response.getStatus() != 200 && response.getStatus() != 201){
         throw new RuntimeException("Failed : HTTP error code : "
         + response.getStatus());
         }*/
















