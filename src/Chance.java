public class Chance extends Field{
    public static CardDeck cardDeck;
    public Chance(int ID, String label) {
        super(ID, label);
        this.cardDeck =null;
    }

    public static void setCardDeck(CardDeck deck) {
        cardDeck = deck;
    }

    @Override
    public String onLand(Player p) {
        Card card = cardDeck.getNext();

        switch (card.getEvent()) {

            case "Pay":
                p.pay(card.getCost());
                break;

            case "receive":
                p.receive(card.getIncome());
                break;

            case "prison":
                //p.moveToPrison(11);
                break;

            case "wildcard":
                // p.setWildcard(true);
                break;

            case "recieveFromPlayers":
                break;

            case "legat" :
                break;

            case "moveToField" :
                break;

            case "moveSteps":
                break;


        }

        return card.getMessage();
    }
}