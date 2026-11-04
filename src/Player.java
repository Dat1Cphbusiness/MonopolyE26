public class Player {
    private static final int LAST_FIELD_POSTION = 40;
    private static final int PERIODIC_INCOME = 4000;
    private String name;
    private int balance;
    private int position;
    private boolean hasWildCard;
    private int lastDiceRoll;

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
            this.lastDiceRoll = value;
        }
        position = newPosition;
        return position;
    }

    @Override
    public String toString() {
        return name + ", " + balance;
    }

    public void receive(int amount) {
        this.balance += amount;
    }

    public void pay(int amount) {
        Bank.withdraw(amount, this);
    }

    public void pay(int amount, Player recipient){
        Bank.transfer(amount, this, recipient);
    }

    public boolean buyProperty(Field f) {
        pay(f.getCost());
        return true;
    }

    public void moveToPosition(int value) {
        this.position = value;
    }


    public void imPrison() {
        boolean inPrison = true;
        moveToPosition(31);
    }

    public boolean hasWildCard() {
        return hasWildCard;
    }

    public void setWildCard(boolean value) {
        this.hasWildCard = value;
    }

    public int getLastDiceRoll() {
        return lastDiceRoll;
    }
}
