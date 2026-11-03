public class Tax extends Field implements IOption{
    private int cost;
    public Tax(int ID, String label,int cost) {
        super(ID, label);
        this.cost = cost;
    }

    @Override
    public String onAccept(Player p) {
        p.pay(cost);
        return "Player " + p.getName() +" paid " + this.cost;
    }

    @Override
    public String onReject(Player p) {
        double amount = p.getTotalWorth(p) * 0.1;
        p.pay(amount);
        return p.getName() + " paid " + amount + " in income tax";
    }

    @Override
    public String onLand(Player p){
        String s = super.onLand(p) + "\n Du skal betale et beløb der svarer til 10% af dine aktiver. Vil du hellere betale et fast beløb på" + this.cost + "kr= Y/N \n";


        return s;
    }
    //1

}
