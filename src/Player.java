public class Player {
    private String name;
    private int balance;
    private int position;
    
    public Player(String name, int startAmount){
        this.name = name;
        this.balance = startAmount;
    }

    public int updatePosition(int value) {
        if (this.position > value) {
            Bank.deposit(200, this);
        }

        this.position = value;

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
