import java.util.Random;

public class Dice {
    private boolean isDouble;
    private int[] diceRoll = new int[2];
    private int dice1;
    private int dice2;
    private int doubleDiceCounter;

    Random random = new Random();


    public int rollDiceSum(){
        dice1 = random.nextInt(6)+1;
        dice2 = random.nextInt(6) +1;

        diceRoll [0] = dice1;
        diceRoll [1] = dice2;

        if (dice1 == dice2){
            isDouble = true;
            doubleDiceCounter++;
        } else {
            isDouble = false;
            doubleDiceCounter = 0;
        }

        return dice1 + dice2;

    }

    public boolean getIsDouble(){
        return isDouble;
    }

    public void resetDoubleDiceCounter () {
        doubleDiceCounter = 0;
    }

    public int getDoubleDiceCounter() {
        return doubleDiceCounter;
    }

    public void setDoubleDiceCounter(int amount) {
        doubleDiceCounter = amount;
    }
}
