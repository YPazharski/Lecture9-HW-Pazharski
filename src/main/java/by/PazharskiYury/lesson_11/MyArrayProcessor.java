package by.PazharskiYury.lesson_11;

public class MyArrayProcessor {

    public static int sumStringNumbersIn4x4Table(String[][] stringTable) {
        if (stringTable.length != 4) {
            throw new MyArraySizeException();
        }

        for (String[] row : stringTable) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }

        }

        int result = 0;

        for (int row = 0; row < stringTable.length; row++) {
            for (int column = 0; column < stringTable[row].length; column++) {
                try {
                    result += Integer.parseInt(stringTable[row][column]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e, row, column);
                }

            }
        }

        return result;
    }

}