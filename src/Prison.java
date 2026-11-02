public class Prison extends Field implements IOption{
    public Prison(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    public String onAccept(Player p){
        return "";
    }

    public String onReject(Player p){
        return "";
    }

}
