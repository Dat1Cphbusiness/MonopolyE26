import java.util.ArrayList;

public class Board {
    private final int MAX_BOARD_SIZE = 40; // Maximum amount of fields per board.
    private Field[] fields = new Field[MAX_BOARD_SIZE];

    public Board(String[] fielddata, String[] carddata) {
        this.createFields(fielddata);
    }

    private void createFields(String[] data) {
        for (String s : data) {
            String[] splitString = s.split(",");
            // String fieldType = splitString[1];
            String fieldLabel = splitString[2].trim();

            try {
                // Parse String to Integer fields.
                int fieldId = Integer.parseInt(splitString[0].trim());
                int fieldCost = Integer.parseInt(splitString[3].trim());
                int fieldIncome = Integer.parseInt(splitString[4].trim());
                // int fieldSeries = Integer.parseInt(splitString[5]);

                // Create field objects from parsed data. Use the fieldId as array index, so data order doesn't matter.
                fields[fieldId] = new Field(fieldId, fieldLabel, fieldCost, fieldIncome);
            } catch (NumberFormatException e) {
                System.out.println("Could not create field from data. Incorrect format!");
            }
        }
    }

    public Field getField(int id) {
        return fields[id];
    }
}
