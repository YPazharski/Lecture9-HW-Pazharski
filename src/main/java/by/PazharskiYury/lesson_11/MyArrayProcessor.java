package by.PazharskiYury.lesson_11;

public class MyArrayProcessor {

    public static int sumStringNumbersIn4x4Table(String[][] stringTable) {
        final int EXPECTED_SIZE = 4;

        if (stringTable.length != EXPECTED_SIZE) {
            throw new MyArraySizeException("Expected number of rows: " + EXPECTED_SIZE + ". Your number of rows: "
                    + stringTable.length + '!');
        }

        for (String[] row : stringTable) {
            if (row.length != EXPECTED_SIZE) {
                throw new MyArraySizeException("Expected number of columns: " + EXPECTED_SIZE + ". Your number of columns: "
                        + row.length + '!');
            }

        }

        int result = 0;

        for (int row = 0; row < stringTable.length; row++) {
            for (int column = 0; column < stringTable[row].length; column++) {
                try {
                    result += Integer.parseInt(stringTable[row][column]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(stringTable[row][column], row, column);
                }

            }
        }

        return result;
    }

}