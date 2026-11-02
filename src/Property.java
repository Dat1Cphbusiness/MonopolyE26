public class Property extends Field{
    private int seriesID;
    private Player owner;
    private boolean isMonopolized;
    
    public Property(String label, int ID, int cost, int income, int seriesID) {
        super(label,ID,cost,income);
        this.seriesID = seriesID;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + seriesID;
    }

    @Override
    public String onLand(Player player) {
        //if (owner != null) optionToBuy(Player player)
        //if (player != owner) payRent(Player player)


        return super.onLand(player);
    }
}
