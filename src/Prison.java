public class Prison extends Field implements IOption{

    public Prison(int id, String label) {
        super(id,label);
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
