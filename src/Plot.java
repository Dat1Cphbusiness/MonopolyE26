public class Plot extends Property {
    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p);

        if (owner == p /*&& checkForMonopoly()*/ ) {
            option = "build";
            msg += "\nVil du bygge? (Y/N)";
        }

        return msg;
    }
}

// Developer B
// I Plot klassens onLand metode foretag flg ændring
// return super.OnLand();
// til: String msg = super.onLand; return msg;
// Imellem erklæring og retunæring af msg lav et if-else syayement der tjekker om owner er p og pm der er monopol på feletet (kald checkFOrMonopoly())
// (OBS: Metoden findes ikke endnu, udkommentere, for at compile)
// true: spilleren ejer ejendommen OG har monopol
// - sæt option til "build" og tilføj flg til msg: msg+= "Vil du bygge?" (Y/N):"
