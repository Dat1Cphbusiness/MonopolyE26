public class Property extends Field implements IOption {
    protected Player owner;
    private int serieID;
    private boolean isMonopolized;

    public Property(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income);
        this.serieID = seriesID;
    }

    @Override
    public String toString() {
        return super.toString() + serieID;
    }

    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p);

        if (owner == null) {
            option = "buy";
            msg += "\nVil du købe? (Y/N)";

            // p.pay(this);

        } else {
            msg += "\nGrunden er ejet og kan ikke købes.";
        }

        return msg;
    }

    @Override
    public String onAccept(Player p) {
        return "";
    }

    @Override
    public String onReject(Player p) {
        return "";
    }
}

// Developer A
// Forsæt if-else blokken
// true: ingen ejer ejendommen, sæt option til "buy", tilføj flg til msg: msg+= "Vil du købe?" (Y/N)"
// - Kald dernæst spillerens pay metode med feltet (this) som argument
// (Obs: Metoden findes ikke endnu , udkommenter, for at compile)
