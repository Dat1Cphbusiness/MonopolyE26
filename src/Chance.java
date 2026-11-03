public class Chance extends Field{
    public static CardDeck cardDeck;
    public Chance(int ID, String label) {
        super(ID, label);
        this.cardDeck =null;
    }


    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p);
        Card card = cardDeck.getNext();

        switch (card.getEvent()) {
            case "payment" -> p.pay(getCost());
            case "reward" -> p.receive(income);
            case "jail" -> p.moveToPosition(11);
            /*case "wildcard" -> //p.setWildcard(true);
            case "takeFerry" -> //ryk frem til nærmeste rederi og... ;
            case "recieveFromPlayers" -> //få penge fra de andre spillere;
            case "legat" -> //Få penge fra banken(?) hvis din formue er lille nok;
            case "moveToField" -> //p.moveToPosition(card.newPosition());
            case "moveSteps" -> //p.moveToPosition(p.updatePosition(card.newPosition());
            case "moveToNearestFerry" -> //Gør det samme som takeFerry?;
            case "paymentPerBuilding" -> //Betal pr. bygning spiller ejer;*/
        }

        return msg + card.getMessage();
    }

}
