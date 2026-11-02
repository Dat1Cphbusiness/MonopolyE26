import java.util.Arrays;
import java.util.Collections;

public class CardDeck {
    private Card[] cards;
    private int counter;

    public CardDeck(String[] carddata) {
        cards = new Card[carddata.length];
        counter = 0;
    }

    public void createCards(String[] data) {
        int count = 0;
        for (String s : data) {
            String[] splitData = s.split(",");
            // Parse string first.
            String cardMessage = splitData[0];
            String cardEvent = splitData[3];

            // Try to parse integer fields.
            try {
                int cardIncome = Integer.parseInt(splitData[1]);
                int cardCost = Integer.parseInt(splitData[2]);
                cards[count] = new Card(cardMessage, cardIncome, cardCost, cardEvent);
                count++; // Use a counter because we are in an enhanced for loop :)
            } catch (NumberFormatException e) {
                System.out.println("Could not create card deck. Invalid data format!");
            }
        }

        // Shuffle cards when finished.
        Collections.shuffle(Arrays.asList(cards));
    }

    public Card getNext() {
        Card nextCard = cards[counter];
        counter++;
        return nextCard;
    }
}
