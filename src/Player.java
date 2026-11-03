import java.util.ArrayList;

public class Player {
    private static final int LAST_FIELD_POSTION = 40;
    private static final int PERIODIC_INCOME = 4000;
    private String name;
    private int balance;
    private int position;
    private ArrayList<Field> deeds = new ArrayList<>();

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

    public void pay(int amount) {
        Bank.withdraw(amount, this);
    }

    public void pay(int amount, int recipient) {
        pay(amount);
        recipient.recieve(amount);
    }

    public void buyProperty(Field f) {
        pay(f.cost);
        deeds.add(f);
    }

    public int getTotalWorth(){
        int total = 0;
        for (Field f: deeds){
            total += f.cost;
            total += balance;
        }
        return total;
    }

    @Override
    public String toString() {
        return name + ", " + balance;
    }
}
