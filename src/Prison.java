public class Prison extends Field implements IOption{

    public Prison(int id, String label) {
        super(id,label);
    }
    @Override
    public String onAccept(Player p) {
        p.setWildCard(false);
        String msg = "\n Du har kontakter hos politiet og løslades";

        return msg;
    }

    @Override
    public String onReject(Player p) {
        p.moveToPosition(31);
        String msg = "\n Næste gang det bliver din tur, kan du vælge om du vil betale dig ud eller prøve at slå et dobbeltslag. Når du har siddet over i tre omgange er du løsladt.";
        return msg;
    }

    @Override
    public String onLand(Player p){
        String msg = super.onLand(p);
        msg+= "\n Du er arrestert, og du skal i fængsel";

        if(p.getWildCard()){
            option = "\n Wille du bruge dit wildcard? (Y/N)";
        } else {
            msg += onReject(p);
        }
        return msg;
    }

}
