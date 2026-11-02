public class Board {
    private Field[] fields;

    public Board(String[] fielddata, String[] carddata) {
        fields = new Field[fielddata.length];
        createFields(fielddata);
     //   CardDeck cd = new CardDeck(carddata);
       // Chance.cardDeck = cd;
    }


    //ID, Grund type, Grund navn, Pris, Pris for andre, Serie ID

    private void createFields(String[] data) {
        for (int i = 0; i < data.length; i++) {
            String[] values = data[i].replaceAll("\\s+", "").split(","); //Fjern alle mellemrum og split på ","

            int ID = Integer.parseInt(values[0]); //Grund ID
            String type = values[1]; //Type af felt
            String label = values[2]; //Navn på felt (Fx rådhuspladsen)
            int cost = Integer.parseInt(values[3]); //Grund pris
            int income = Integer.parseInt(values[4]); //Pris for andre spillere at lande på et allerede ejet felt af anden spiller
            int seriesID = Integer.parseInt(values[5]); //SeriesID fra property (Bruges ikke endnu - skal bruges senere)


            fields[i] = new Field(ID, label, cost, income);
        }
    }

    public Field getField(int id) {
        return fields[id-1];
    }
}
