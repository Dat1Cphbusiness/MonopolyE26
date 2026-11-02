public class Player {
    private String name;
    private int score;
    private int balance;
    private int position;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.balance = 1000;
        this.position = 1;
    }

    @Override
    public String toString(){
        return name + ", "+ score;
    }

    public String getName(){
        return this.name;

    }

    public int updatePosition(int value) {
        position += value;
        if (position > 40) {
            position -= 40;
        }
        return position;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount) {
        balance = amount;
    }
}
