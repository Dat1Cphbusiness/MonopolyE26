public class Board {
    private Field[] fields;

    public Board(String[] fielddata, String[] carddata) {
        fields = new Field[fielddata.length];
        createFields(fielddata);
       // Chance.cardDeck = new CardDeck(carddata);

    }


    //ID, Grund type, Grund navn, Pris, Pris for andre, Serie ID

    private void createFields(String[] data) {
        for (int i = 0; i < data.length; i++) {
            String[] values = data[i].split(","); //TODO: tidligere metode har fjernet ALLE mellemrum (Fjernet: .replaceAll("\\s+", ""))

            int ID = Integer.parseInt(values[0].trim()); //Grund ID //TODO: tilføjet: .trim() til argument
            String type = values[1].trim(); //Type af felt //TODO: tilføjet: .trim() til argument
            String label = values[2].trim(); //Navn på felt (Fx rådhuspladsen) //TODO: tilføjet: .trim() til argument
            int cost = Integer.parseInt(values[3].trim()); //Grund pris //TODO: tilføjet: .trim() til argument
            int income = Integer.parseInt(values[4].trim()); //Pris for andre spillere at lande på et allerede ejet felt af anden spiller //TODO: tilføjet: .trim() til argument
            int seriesID = Integer.parseInt(values[5].trim()); //SeriesID fra property (Bruges ikke endnu - skal bruges senere) //TODO: tilføjet: .trim() til argument

            Field f = null;

            switch (type) {
                case "Chance":
                    f = new Chance(ID, label);
                    break;
                case "Start":
                    f = new Start(ID, label, income);
                    break;
                case "Plot":
                    f = new Plot(ID, label, cost, income, seriesID); //TODO: skiftet rundt på income og cost felter bliver angivet korrekt
                    break;
                case "ShippingLine":
                    f = new ShippingLine(ID, label, cost, income, seriesID); //TODO: skiftet rundt på income og cost felter bliver angivet korrekt
                    break; //Tuborg squash
                case "Tax":
                    f = new Tax(ID,label,cost);
                    break;
                case "Brewery":
                    f = new Brewery(ID, label, cost, income, seriesID); //TODO: skiftet rundt på income og cost felter bliver angivet korrekt
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
