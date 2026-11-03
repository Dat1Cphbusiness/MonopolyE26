public class Property extends Field implements IOption {
    private Player owner;
    private int serieID;
    private boolean isMonopolized;

    public Property(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income);
        this.serieID = seriesID;
        this.owner = null;
    }

    @Override
    public String toString() {
        return super.toString() + serieID;
    }

    @Override
    public String onLand(Player p) {
        //Du er landet på x feldt
        //Det er "x type flet"
        //hvis property(ejet) = ejet af x person betal = deeds leje (ejer du dne selv)
        //else
        //du kan købe denne grund for x penge deed = show.

        String msg = super.onLand(p);
        if (owner == null) {
            option = "buy";
            msg += "Vil du købe? (Y/N)";
        } else {
            if (owner != p){
                msg += "Du skal betale " + income;
            } else {
                //p.pay(this);
            }
        }
        return msg;
    }


    @Override
    public String onAccept(Player p) {
        if (option.equalsIgnoreCase("buy")) {
            p.buyProperty(this);
            this.owner = p;
            //checkForMonopoly();
            return p.getName() + " has bought this property: " + this.label;
        } else {
            return p.getName() + " This message shouldnt apear in program :) ";
        }

    }

    @Override
    public String onReject(Player p) {
        return "";
    }

    protected Player getOwner() {
        return owner;
    }
}
