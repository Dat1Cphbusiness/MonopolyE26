public class Plot extends Property {

    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    @Override
    public String toString () {
        return super.toString();
    }

    @Override
    public String onLand (Player player) {
        return super.onLand(player);
    }
}

// Developer B
// - opret på samme måde klassen Plot som nedarver fra Property. Generer kode til at overide metoderne
// - I onLand metoden skal der på sigt skrives kode der bygger på algoritmen
