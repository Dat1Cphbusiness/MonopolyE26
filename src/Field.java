public class Field {
    private String label;
    private int ID;
    private int cost;
    private int income;
    private String option;

    public Field(String label, int ID, int cost, int income){
        this.label = label;
        this.ID = ID;
        this.cost = cost;
        this.income = income;
    }

    public String onLand(Player p){
        return p.getName() + " er landet på felt " + ID + ", " + label;
    }


    @Override
    public String toString(){
        return ID + ", " + label;
    }
}
