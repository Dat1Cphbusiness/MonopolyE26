public class Prison extends  Field implements IOption{
    public Prison(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    public String onAccept(){
        return null;
    }


    public String onReject(){
        return null;
    }
}
