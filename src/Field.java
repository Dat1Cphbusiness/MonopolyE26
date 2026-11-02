public class Field {
    private String label;
    private int ID;
    private int count;
    private int income;
    private String option;

public Field (int ID, String label, int count, int income) {
    this.ID = ID;
    this.label = label;
    this.count = count;
    this.income = income;
}

    @Override
    public String toString() {
        return "Felt " + ID + ", " + label;
    }

    public String onLand(Player player) {
        return player.getName() + " er landet på felt " + ID + ", " + label;
    }

}

// Developer A
// Lav en feature branch: Sprint4-field-par
// - Opret Field klassen med konstrucktor og metoder der følger klassediagrammet doc/plan/static/classdiagram_v1.puml
// Implementerer en toString() metode der retunere feltets ID og label
// Implementerer onLand(Player player) så den retunerer hvem der er landet og hvor
// Eksempel: "Eggon er landet på felt 4, Hvidrodsvej"
// - Opret klassen property som nedarver fra Field og har ekstra attributer: int serieID , boolean isMonopolized


