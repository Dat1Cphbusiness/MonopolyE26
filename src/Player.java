public class Player {
    private static final int LAST_FIELD_POSTION = 40;
    private static final int PERIODIC_INCOME = 4000;
    private String name;
    private int balance;
    private int position;

    public Player(String name, int startAmount) {
        this.name = name;
        this.balance = startAmount;
        this.position = 1;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public int updatePosition(int value) {
        int newPosition = position + value;
        if (newPosition > LAST_FIELD_POSTION) {
            newPosition = newPosition - LAST_FIELD_POSTION;
            Bank.deposit(4000, this);
        }
        position = newPosition;
        return position;
    }

    @Override
    public String toString() {
        return name + ", " + balance;
    }

}
