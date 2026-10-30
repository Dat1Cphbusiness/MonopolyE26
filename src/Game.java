import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    private String name;
    private List<Player> players;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    private Player currentPlayer;


    public Game(String name){
        this.name = name;
        players = new ArrayList<>();

    }
    public void startSession() {
        ui.displayMessage("Welcome to Matador");
        ArrayList<String> data = io.readData("data/playerData.csv");
        if (!data.isEmpty() && ui.promptBinary("Continue previously saved game? Y/N")) {
            for (String s : data) {
                String[] values = s.split(",");// "tess, 0". --> ["tess", "0"]
                String name = values[0];
                int balance = Integer.parseInt(values[1].trim());
                createPlayer(name, balance);
            }

        }else {
            registerPlayers();
        }

    }
    public void registerPlayers(){
        int totalPlayers = ui.promptNumeric("Hvor mange spillere? (2-6)");
        if(2<=totalPlayers && totalPlayers<=6){
            while(this.players.size() < totalPlayers) {
                String playerName = ui.promptText("Tast spiller navn");
                this.createPlayer(playerName, 0);
                Collections.shuffle(players);
            }
        } else {
            System.out.println("Du skal vælge et tal mellem 2 og 6!");
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
    public void runGameLoop() {
         currentPlayer = players.get(0);
        ui.displayMessage("It is " + currentPlayer.getName() + "'s turn");
    }
}