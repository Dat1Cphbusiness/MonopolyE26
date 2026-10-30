import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    private Player currentPlayer;


    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();

    }
    public void startSession(){
        ArrayList<String> data = io.readData("data/playerData.csv");
        if(data.isEmpty()){
            registerPlayers();
        }else {
            for (String s : data) {
                //instantier en player
                String[] values = s.split(",");// "tess, 0". --> ["tess", "0"]
                String name = values[0];
                int balance = Integer.parseInt(values[1].trim());
                Player p = new Player(name, balance);
                players.add(p);

            }
        }

    }
    public void registerPlayers() {
        int playerNum = ui.promptNumeric("Tast antal deltagere.");
        boolean isValidNumber = false;
        try {
            if (playerNum <= maxPlayers && playerNum >= 2 && !isValidNumber)
                while (this.players.size() < this.maxPlayers && this.players.size() <= playerNum) {
                    String playerName = ui.promptText("Tast spiller navn");
                    this.createPlayer(playerName, 0);
                }else if(playerNum == this.players.size()){
                isValidNumber=true;
            }
        }catch(IllegalArgumentException e){
            System.out.println("Ugyldigt antal spillere, vælg mellem 2-6.");
            registerPlayers();
        }
    }


    private void createPlayer(String name, int score){
        Player p = new Player(name, score);
        players.add(p);
    }

    public void displayPlayers(){
        for(Player p:players){
            System.out.println(p);
        }
    }
    public void endSession(){
        ArrayList<String> playersData = new ArrayList<>();
       // persister data

        for(Player p:players){
            playersData.add(p.toString());

        }
        io.saveData(playersData, "data/playerData.csv", "Name, Balance");
    }
}