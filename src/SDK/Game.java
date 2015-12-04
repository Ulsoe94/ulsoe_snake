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
    private String status;
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

    public int getMapSize() {
        return mapSize;
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

    public Gamer getHost(){
        return host;
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

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Gamer getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }
} //end of class
