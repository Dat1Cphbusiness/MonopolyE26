public class Bank {
    private static int balance = 1000000;

    public static void deposit(int amount, Player p) {
        p.setBalance(p.getBalance() + amount);
        balance -= amount;
    }

    public static boolean withdraw(int amount, Player p) {
        if (amount >= p.getBalance()) {
            p.setBalance(p.getBalance() - amount);
            balance += amount;
            return true;
        }
        return false;
    }

    public static boolean transfer(int amount, Player giver, Player recipient) {
        return false; //Ikke et krav i dette sprint (sprint 5)
    }

    public static int getBalance() {
        return balance;
    }
}
