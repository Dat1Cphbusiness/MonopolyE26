public class Dice {
    // Constant fields
    private final int DICE_SIDES = 6;

    // Variable fields
    private boolean isDouble;
    private int doubleDiceCounter = 0;
    int[] diceRoll = new int[2];

    public int rollDiceSum(){
        int x = (int) (Math.random() * (DICE_SIDES)) + 1; // Cast from double to int.
        int y = (int) (Math.random() * (DICE_SIDES)) + 1;
        diceRoll[0] = x;
        diceRoll[1] = y;

        // Check if the two results match
        if (x == y) {
            this.isDouble = true;
            doubleDiceCounter++;
        } else {
            this.isDouble = false;
            this.resetDoubleDiceCounter();
        }
        return x + y;
    }

    public void resetDoubleDiceCounter() {
        this.doubleDiceCounter = 0;
    }

    public boolean getIsDouble(){
        return this.isDouble;
    }


}
