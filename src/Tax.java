public class Tax extends Field implements IOption{
    private int cost;
    public Tax(int ID, String label,int cost) {
        super(ID, label);
        this.cost = cost;
    }

    @Override
    public String onAccept(Player p) {
        //p.pay(cost);
        return "Du har lige betalt " + cost + " kr";
    }

    @Override
    public String onReject(Player p) {
        //int tax = p.getTotalWorth();
        //p.pay(tax);
        int tax = 100;
        return "Du har lige betalt 10% af din net worth: " + tax + " kr ";
    }
    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        s += "\n Du skal betale et beløb der svare til 10% af dine aktiver. Vil du hellere betale et fast beløb på " + this.cost + "kr Y/n";
        return s;

    }


}
