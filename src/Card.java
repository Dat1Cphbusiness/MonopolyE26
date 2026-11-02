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

    public int getIncome() {
        return income;
    }

    public int getCost() {
        return cost;
    }

    public String getMessage() {
        return message;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return message + ", " + income + ", " + cost + ", " + event;
    }
}
