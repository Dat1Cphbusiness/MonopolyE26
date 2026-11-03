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
    private Board board;
    private Dice dice = new Dice();

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
               createPlayer(name, balance);
            }

        }else {
            registerPlayers();
        }
        createAssets();
    }

    public void createAssets(){
           String[] fielddata = io.readData("data/fielddata.csv", 40);
           String[] carddata = io.readData("data/carddata.csv", 100);
           board = new Board(fielddata, carddata);
    }

    public void runGameLoop(){
        int count = 0;
        boolean continueGame = true;

        while (continueGame){
            currentPlayer = players.get(count % players.size());
            throwAndMove();
            continueGame = ui.promptBinary("\n Fortsæt? Y/N \n");
            count++;
        }

    }

    public void registerPlayers() {

        int totalPlayers = ui.promptNumeric("Tast antal spillere");

        if(!(totalPlayers >= 2 && totalPlayers <= maxPlayers)){
            ui.displayMessage("UGYLDIGT ANTAL");
            registerPlayers();
            return;
        }

        while (this.players.size() < totalPlayers) {

            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 30000);
        }

        Collections.shuffle(players);
    }


    private void createPlayer(String name, int score) {
        Player p = new Player(name, score);
        players.add(p);
    }

    public void displayPlayers() {
        ui.displayMessage("*****SCORE BOARD****");
        for (Player p : players) {
            System.out.println(p);
        }
        ui.displayMessage("**********************");
    }

    public void endSession() {
        ArrayList<String> playersData = new ArrayList<>();

        for (Player p : players) {
            playersData.add(p.toString());

        }
        System.out.println("Spillet er slut");
        io.saveData(playersData, "data/playerData.csv", "Name, Balance");
    }

    public void throwAndMove(){
        displayPlayers();
        ui.displayMessage("Det er " + currentPlayer.getName() + "'s tur");
        int result = 3;//dice.rollDiceSum();
        ui.displayMessage(currentPlayer.getName()+" slog "+result);
        int newPosition = currentPlayer.updatePosition(result);
        Field f = board.getField(newPosition);
        this.landAndAct(f);
    }

    public void landAndAct(Field f){
        String msg = f.onLand(currentPlayer);
        boolean response = false;

        IOption optionField = null;
        if(f.getOption() !=null){//option "BUY""
            optionField = (IOption) f;
            response= ui.promptBinary(msg);
        }else{
            ui.displayMessage(msg);
       }

      if(response){
          msg = optionField.onAccept(currentPlayer);
      }else{
          msg= optionField.onReject(currentPlayer);
      }
      ui.displayMessage(msg);
}

}
