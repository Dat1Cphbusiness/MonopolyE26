public class Player {
    private static final int MAX_BOARD_FIELDS = 40;

    private String name;
    private int balance;
    private int position;
    
    public Player(String name, int startAmount){
        this.name = name;
        this.balance = startAmount;
    }

    public int updatePosition(int value) {
        this.position += value;
        if (this.position > MAX_BOARD_FIELDS) {
            this.position -= MAX_BOARD_FIELDS;
            Bank.deposit(200, this);
        }

        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return name + ", "+ this.balance;
    }
}
