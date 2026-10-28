import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();


    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();

    }
    public void startSession(){

        ui.displayMessage("Velkommen til Matador!");

        ArrayList<String> data = io.readData("data/playerData.csv");
        if (!data.isEmpty() && ui.promptBinary("Continue previously saved game? Y/N")) {
            for (String s : data) {
                //instantier en player
                String[] values = s.split(",");// "tess, 0". --> ["tess", "0"]
                String name = values[0];
                int balance = Integer.parseInt(values[1].trim());
                Player p = new Player(name, balance);
                players.add(p);
            }
        } else {
            registerPlayers();
        }

    }
    public void registerPlayers(){

        while(this.players.size() < this.maxPlayers) {

            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0);
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