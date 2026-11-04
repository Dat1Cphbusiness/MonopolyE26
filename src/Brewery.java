public class Brewery extends Property{
    public Brewery(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    @Override
    public String toString() {

        return super.toString();
    }

    @Override
    public String onLand(Player p) {
        p.getLastDiceRoll();
        return super.onLand(p);
    }
}
