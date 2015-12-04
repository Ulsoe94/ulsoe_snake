package SDK;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Ulso on 23/11/15.
 */
public class ServerConnection {

    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    private String hostAddress;
    private int port;


    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }



    //Method get.
    public String get(String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        System.out.println(response);

        return response.getEntity(String.class);
    }


    //method post
    public ClientResponse post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
        System.out.println(response);

        return response;
    }

    //method put
    public String put(String json, String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return response.getEntity(String.class);

    }

    //method delete
    public String delete(String path){
        Client client = Client.create();
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return response.getEntity(String.class);


    }

    public boolean joinGame(Game game){
        String path = "games/join/";
        String data = new Gson().toJson(game, Game.class);

        try {
            put(data, path);
        }
        catch ( Exception ex) {
            return false;
        }
        return true;
    }



    //method getHighscore
    public  Score[] Highscore() {
        String path = "scores/";
        String response;
        try {
            response = get(path);
        } catch (Exception ex) {
            return null;
        }
        Score[] scores = new Gson().fromJson(response, Score[].class);
        return scores;

    }

    public boolean deleteGame(String gameId){
        String path ="games/"+gameId;
        try {
            delete(path);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Game startGame (Game game) {
        String path = "games/start/";
        String json = new Gson().toJson(game, Game.class);

        try {
            put(json, path);
        } catch (Exception ex) {
            return null;
        }
        return null;
    }


    }



