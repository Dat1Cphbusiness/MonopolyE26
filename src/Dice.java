import java.util.Random;

public class Dice {
    private int[] diceRoll = new int[2];
    private boolean isDouble;
    private int doubleDiceCounter;

    public int rollDiceSum() {
        Random random = new Random();

        diceRoll[0] = random.nextInt(6) + 1;
        diceRoll[1] = random.nextInt(6) + 1;

        if (diceRoll[0] == diceRoll[1]) {
            isDouble = true;
            doubleDiceCounter++;
        } else {
            isDouble = false;
            doubleDiceCounter = 0;
        }

        return diceRoll[0] + diceRoll[1];
    }
    public boolean getIsDouble(){
        return isDouble;
    }
    public int getDoubleDiceCounter(){
        return doubleDiceCounter;
    }
    public void resetDoubleDiceCounter(){

    }

}
