public class Field {
    protected String label;
    private int ID;
    private int cost;
    protected int income;
    protected String option;

    public Field(int ID, String label, int cost, int income) {
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    public Field(int ID, String label) {
        this.ID = ID;
        this.label = label;
    }


    @Override
    public String toString() {
        return label;
    }

    public String onLand(Player p) {
        return p.getName() + " er landet på " + this+"\n";
    }

    public String getOption() {
        return option;
    }

    public int getCost() {
        return cost;
    }
}
