public class Chance extends Field implements IOption{
    public static CardDeck cardDeck;
    public Chance(int ID, String label) {
        super(ID, label);
        this.cardDeck =null;
    }

    @Override
    public String onLand(Player p){
        Card card = cardDeck.getNext();
        switch (card.getEvent()){
            case "recieveFromPlayers" ->{
            }
            case "takeFerry" ->{
                p.setPosition(getNearestFerry(p));
                //if ()
            }
            case "reward" -> Bank.deposit(income,p);
            case "payment" -> p.pay(getCost());
            case "legat" -> {}
            case "wildcard" -> p.wildCard(true);
            case "moveToField" -> {
                int distanceToPosition = 0;
                if (p.getPosition() < card.getNewPosition()){
                    distanceToPosition= p.getPosition()-card.getNewPosition();
                } else { distanceToPosition = card.getNewPosition()-p.getPosition();}
                p.updatePosition(distanceToPosition);
            }
            case "moveSteps" -> p.updatePosition(card.getNewPosition());
            case "moveToNearestFerry" -> p.setPosition(getNearestFerry(p));
            case "jail" -> p.setPosition(card.getNewPosition());
            case "paymentPerBuilding" -> {}
            default -> {}


        }

        return card.getMessage();
    }

    @Override
    public String onAccept(Player p) {
        return "";
    }

    @Override
    public String onReject(Player p) {
        return "";
    }

    public int getNearestFerry(Player p) {
        int position = p.getPosition();

        if (position < 6) {
            return 6;
        } else if (position < 16) {
            return 16;
        } else if (position < 26) {
            return 26;
        } else {
            return 36;
        }
    }
}
