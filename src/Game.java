import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    private Player currentPlayer;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();


    public Game(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
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
                Player p = new Player(name, balance);
                players.add(p);
            }

        }else {
            registerPlayers();
        }

    }


    public void registerPlayers() {
        int promptNumberOfPlayers = 0;

        try {
             promptNumberOfPlayers = ui.promptNumeric("Indtast antal af spillere: ");
        } catch (NumberFormatException e){
            System.out.println("ugyldigt input, prøv igen");
            registerPlayers();
        }

        if (promptNumberOfPlayers < 2 || promptNumberOfPlayers > maxPlayers){
            registerPlayers();
        }

        while (this.players.size() < promptNumberOfPlayers) {

            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0);
        }
        Collections.shuffle(players);
    }


    private void createPlayer(String name, int score) {
        Player p = new Player(name, score);
        players.add(p);
    }

    public void displayPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }
    }

    public void endSession() {
        ArrayList<String> playersData = new ArrayList<>();
        // persister data

        for (Player p : players) {
            playersData.add(p.toString());

        }
        io.saveData(playersData, "data/playerData.csv", "Name, Balance");
    }

    public void runGameLoop(){
        this.currentPlayer = players.get(0);
        System.out.println("Det er " + currentPlayer.getName() + "'s tur");


    }
}