public class Tax extends Field implements IOption{
    private int cost;
    public Tax(int ID, String label,int cost) {
        super(ID, label);
        this.cost = cost;
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
