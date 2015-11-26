package SDK;

import com.google.gson.Gson;


/**
 * Created by Ulso on 23/11/15.
 */
public class Logic {

    static ServerConnection serverConnection = new ServerConnection();

    public static void login(String username, String password){

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        String json = new Gson().toJson(user);

        serverConnection.post(json, "login/");

    }
    public static void createUser(User user){

        String json = new Gson().toJson(user);

        serverConnection.post(json, "user/");
    }

    public static void deleteUser(int userId){

    }
    public static void getUser(int userId){

    }
    public static void getGame(int gameId){
        String json = new Gson().toJson(gameId);

        //serverConnection.get(json, "gameId/");
    }
    public static void joinGame(int gameId, User opponent, String controls){

    }
    public static void startGame(int gameId){

    }
    public static void createGame(Game game){

        String json = new Gson().toJson(game);

        serverConnection.post(json, "create");

    }
    public static void deleteGame(int gameId){



    }


}
