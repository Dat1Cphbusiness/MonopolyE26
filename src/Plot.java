public class Plot extends Property{

    public Plot(int ID, String label, int cost, int income, int serieID) {
        super(ID, label, cost, income, serieID);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public String onLand(Player p) {
        return super.onLand(p);
        // først skal der checkes om feltet er købt af nogen
        // der skal være en metode der checker om spilleren ejer prooertien,
        // hvis ikke og en anden spiller ejer den, skal der betales leje,
        // hvis spilleren selv ejer den skal muligheden for opgraderinger gives
    }
}
