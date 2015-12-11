package SDK;

/**
 * Created by Ulso on 23/11/15.
 */
public class Game {
    //Creating the variables needed for the game
    private int gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private java.sql.Date created;
    private int mapSize;

    public Game(){}

    //getters and setters
    public java.sql.Date getCreated() {
        return created;
    }

    public void setCreated(java.sql.Date created) {
        this.created = created;
    }



    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameId(){
        return gameId;
    }

    public void setGameId(int gameId){
        this.gameId = gameId;
    }


    public void setHost(Gamer host){
        this.host = host;
    }

    public Gamer getOpponent(){
        return opponent;
    }

    public void setOpponent(Gamer opponent){
        this.opponent = opponent;
    }

} //end of class
