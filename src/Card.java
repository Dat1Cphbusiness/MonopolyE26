public class Card {
    private String message;
    private int income;
    private int cost;
    private String event;
    private int newPosition;

    public Card(String message, int income, int cost, String event, int newPosition) {
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
        this.newPosition = newPosition;
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

    public int getNewPosition() {
        return newPosition;
    }

    @Override
    public String toString() {
        return message + ", " + income + ", " + cost + ", " + event;
    }
}
