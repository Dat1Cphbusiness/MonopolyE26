public class Field {
    private String label;
    private int ID;
    private int cost;
    private int income;
    private String option;

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
        return "ID: " + ID + "\nLabel: " + label;
    }


    public String onLand(Player p) {
        return p.getName() + " has landed on field " + this;
    }
}
