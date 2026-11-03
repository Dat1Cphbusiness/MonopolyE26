public class Tax extends Field implements IOption{
    private int cost;
    public Tax(int ID, String label,int cost) {
        super(ID, label);
        this.cost = cost;
    }

    @Override
    public String onAccept(Player p) {
        p.pay(cost);
        return "Du betalte " + cost + " kr. til skat";
    }

    @Override
    public String onReject(Player p) {
        int totalworth = 20000;//p.getTotalWorth();
        double afterTax = totalworth*0.10;
        p.pay(afterTax);
        return "Du betalte 10% af in værdi " + afterTax + " kr. til skat";
    }

    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        s += "\n Du skal betale et beløb der svarer til 10% af dine aktiver. Vil du hellere betale et fast beløb på" + this.cost + "kr? Y/N \n";
        return s;
    }

}
