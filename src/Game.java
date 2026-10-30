import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Game {



    private Player currentPlayer;
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

    public void createGameAssets(){


    }

    public void startSession(){
        ArrayList<String> data = io.readData("data/playerData.csv");
        ui.displayMessage("Velkommen til Matador");
        if(!data.isEmpty() && ui.promptBinary("Continue previously saved game? Y/N")){
            for (String s : data) {

                String[] values = s.split(",");// "tess, 0". --> ["tess", "0"]
                String name = values[0];
                int balance = Integer.parseInt(values[1].trim());
                Player p = new Player(name, balance);
                players.add(p);

            }
            return;
        }
        registerPlayers();

    }
    public void registerPlayers(){
        int playerNum = ui.promptNumeric("Tast antal deltagere:");
        if  (playerNum >= 2 && maxPlayers >= playerNum) {
            while (playerNum > players.size()) {

                name = ui.promptText("Tast spiller nr: " + (players.size() + 1) +  "/" + playerNum +" navn på spiller:" );
                createPlayer(name, 0);
            }
        } else {System.out.println("Tast et tal mellem 2 og 6"); registerPlayers();}
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
        System.out.println("Spillet er afsluttet");
        for(Player p:players){
            playersData.add(p.toString());

        }

        io.saveData(playersData, "data/playerData.csv", "Name, Balance");
    }

    public void runGameLoop(){
        int count = 0;
        boolean continueGame = true;
        Collections.shuffle(players);
        while (continueGame){
        currentPlayer = players.get(count % players.size());
        throwAndMove();
        continueGame = ui.promptBinary("Fortsæt spillet? (Y/N)");
        count++;}

    }

    public void throwAndMove(){
        System.out.println("Det er " + currentPlayer.getPlayerName() + " tur!");

    }

    public void landAndAct(){


    }




}