public class Bank {
    private static int balance = 1000000;

    public static void deposit(int amount, Player player) {
        if (balance < amount) {
            System.out.println("Der er ikke nok penge i banken! :(");
            return;
        }
        balance -= amount;

        player.setBalance(player.getBalance() + amount);
    }

    public static boolean withdraw(int amount, Player player) {
        if (player.getBalance() < amount) {
            System.out.println("Der er ikke nok penge på " + player.getName() + "'s konto");
            return false;
        }
        balance += amount;
        player.setBalance(player.getBalance() - amount);
        return true;
    }
}
