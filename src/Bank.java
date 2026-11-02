public class Bank {
    private static int balance = 1000000;

    public static boolean withdraw(int amount, Player p) {
        if (p.getBalance() > amount) {
            p.setBalance(p.getBalance() - amount);
            balance += amount;
            return false;
        }
        return true;
    }

    public static boolean deposit(int amount, Player p) {
        p.setBalance(p.getBalance() + amount);
        balance -= amount;
        return true;
    }


}
