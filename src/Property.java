public class Property extends Field {
    private Player owner;
    private int seriesID;
    private boolean isMonopolized;

    public Property (int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income);
        this.owner = owner;
        this.seriesID = seriesID;
        this.isMonopolized = false;

    }


}
