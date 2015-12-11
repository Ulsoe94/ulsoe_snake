package SDK;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Ulso on 23/11/15.
 */
public class ServerConnection {

    private String hostAddress;
    private int port;

    public ServerConnection(){ //constructor for ServerConnection
        hostAddress = "http://localhost";
        port = 8888;
    }

    //getters
    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }



    //Method get.
        public String get(String path){

            Client client = Client.create(); //Creating an instance to a web Resource hosted at the below URI
            WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path); //The URI

            ClientResponse response = webResource.type("application/json").get(ClientResponse.class); //Response set to JSON data.

        if (response.getStatus() != 200 && response.getStatus() != 201) { //if statement for serverstatus 200 & 201
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        System.out.println(response);

        return response.getEntity(String.class);
    }




    //method post
    public ClientResponse post(String json, String path){

        Client client = Client.create();//Creating an instance to a web Resource hosted at the below URI
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path); //THe URI

        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);//Response set to JSON data.

        System.out.println(response);
        return response;
    }

    //method put
    public String put(String json, String path) {
        Client client = Client.create();//Creating an instance to a web Resource hosted at the below URL
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json); //Response set to JSON data.



        if (response.getStatus() != 200 && response.getStatus() != 201) { //if statement for serverstatus 200 & 201
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        System.out.println(response.getStatus());
        return response.getEntity(String.class);

    }

    //method delete
    public String delete(String path){
        Client client = Client.create();//Creating an instance to a web Resource hosted at the below URI
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);//Response set to JSON data.




        if (response.getStatus() != 200 && response.getStatus() != 201) { //if statement for serverstatus 200 & 201
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        System.out.println(response);
        return response.getEntity(String.class);


    }

    //method joinGame
    public boolean joinGame(Game game){
        String path = "games/join/"; //Path specified for the URI
        String data = new Gson().toJson(game, Game.class); //data converted to json

        try { //try statement
            put(data, path);
        }
        catch ( Exception ex) {
            return false;
        }
        return true;
    }





    //method Highscore
    public  Score[] Highscore() {
        String path = "scores/"; //Path specified for the URI
        String response; //String response
        try {
            response = get(path);
        } catch (Exception ex) {
            return null;
        }
        Score[] scores = new Gson().fromJson(response, Score[].class); //data from response converted to Gson
        return scores;

    }

    //method deleteGame
    public boolean deleteGame(String gameId){
        String path ="games/"+gameId; //Path specified for the URI
        try {
            delete(path);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    //method startGame
    public Game startGame (Game game) {
        String path = "games/start/"; //Path specified for the URI
        String data = new Gson().toJson(game, Game.class); //data converted to json

        try {
            put(data, path);
        } catch (Exception ex) {
            return null;
        }
        return null;
    }


    }



