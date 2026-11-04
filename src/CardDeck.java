import java.util.Arrays;
import java.util.Collections;

public class CardDeck {
    private Card[] cards;
    private int counter = 0;

    public CardDeck(String[] cardData) {
        cards = new Card[cardData.length];
        createCards(cardData);
        Collections.shuffle(Arrays.asList(cards));
    }

    public Card getNext() {
        if (counter >= cards.length) {
            counter = 0;
        }
        Card card = cards[counter];
        counter++;
        return card;
    }

    private void createCards(String[] data) {
        for (int i = 0; i < data.length; i++) {
            String[] values = data[i].split(";");
            String message = values[0];
            int income = Integer.parseInt(values[1].trim());
            int cost = Integer.parseInt(values[2].trim());
            String event = values[3];

            Card c = new Card(message, income, cost, event);
            cards[i] = c;
        }
    }

    public void resetCounter() {
        this.counter = 0;
    }


}
