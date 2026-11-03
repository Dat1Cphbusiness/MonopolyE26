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
        // Spiller lander på property
        // Er den ejet af en andens spiller, og ejeren ikke er currentPlayer = pay rent
        // er den ikke ejet af en anden spiller = Give option to buy
        String s = super.onLand(p);
        s+= " kunne du tænke at købe" +this.label;
        return s;
    }
}
