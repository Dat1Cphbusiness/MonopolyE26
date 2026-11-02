public class Card {
    private String message;
    private int income;
    private int cost;
    private String event;

    public Card(String message, int income, int cost, String event) {
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
    }

    public String getMessage() {
        return this.message;
    }

    public int getIncome() {
        return this.income;
    }

    public int getCost() {
        return this.cost;
    }

    public String getEvent() {
        return this.event;
    }

    @Override
    public String toString() {
        return this.message + "," + this.income + "," + this.cost + "," + this.event;
    }
}
