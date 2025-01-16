package by.PazharskiYury.lesson_11;

import java.util.Arrays;

public class MyArrayProcessor {

    public static int sumStringNumbersIn4x4Table(String[][] stringTable) throws MyArraySizeException, MyArrayDataException {
        final int EXPECTED_SIZE = 4;

        if (stringTable.length != EXPECTED_SIZE) {
            throw new MyArraySizeException("Expected number of rows in \"stringTable\": " + EXPECTED_SIZE + ". Actual number of rows: "
                    + stringTable.length + '!');
        }

        for (int i = 0; i < stringTable.length; i++) {
            if (stringTable[i].length != EXPECTED_SIZE) {
                throw new MyArraySizeException("Expected number of columns in the row " + Arrays.toString(stringTable[i])
                        + " of index " + i + " in \"stringTable\": " + EXPECTED_SIZE + ". Actual number of columns: " + stringTable[i].length + '!');
            }

        }

        int result = 0;

        for (int row = 0; row < stringTable.length; row++) {
            for (int column = 0; column < stringTable[row].length; column++) {
                try {
                    result += Integer.parseInt(stringTable[row][column]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("\"stringTable\" " + Arrays.deepToString(stringTable)
                            + " has one or more elements that can't be recognized as integer. The first of them is in the ROW "
                            + row + ", COLUMN " + column + '!');
                }

            }
        }

        return result;
    }

}