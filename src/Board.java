public class Board {
    private Field[] fields;

    public Board(String[] fielddata, String[] carddata) {
        fields = new Field[fielddata.length];
        createFields(fielddata);
        //Chance.cardDeck = new CardDeck(carddata);

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

            Field f = null;

            switch (type) {
                case "Chance":
                    f = new Chance(ID, label);
                    break;
                case "Start":
                    f = new Start(ID, label, income);
                    break;
                case "Plot":
                    f = new Plot(ID, label, cost, income, seriesID);
                    break;
                case "ShippingLine":
                    f = new ShippingLine(ID, label, cost, income, seriesID);
                    break;
                case "Tax":
                    f = new Tax(ID,label,cost);
                    break;
                case "Brewery":
                    f = new Brewery(ID, label, cost, income, seriesID);
                    break;
                case "Parking":
                    f = new Parking(ID, label);
                    break;
                case "Prison":
                    f = new Prison(ID, label);
                    break;
                case "Visit":
                    f = new Visit(ID, label);
                    break;
                default:
                    System.out.println("No such type available");
                    break;
            }
            fields[i] = f;
        }
    }

    public Field getField(int id) {


        return fields[id-1];
    }
}
