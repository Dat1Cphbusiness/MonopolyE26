import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    private Player currentPlayer;

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

    public void runGameLoop(){
        int count = 0;
        boolean continueGame = true;
        while (continueGame) {
            if (count == players.size()){
                count = 0;
            }
            currentPlayer = players.get(count);
            count++;
            ui.displayMessage("Det er " + currentPlayer.getName() + "' tur");
            continueGame = ui.promptBinary("Fortsæt? Y/N");
        }

    }

    public void registerPlayers() {

        //bed om antal spillere
        int totalPlayers = ui.promptNumeric("Tast antal spillere");

        //tjek om det er mellem min(2) og max(3)
        if(!(totalPlayers >= 2 && totalPlayers <= maxPlayers)){
            ui.displayMessage("UGYLDIGT ANTAL");
            registerPlayers();
            return;
        }
        //kald metoden rekursivt hvis ikke



        while (this.players.size() < totalPlayers) {

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
        System.out.println("Spillet er afsluttet");
    }
}