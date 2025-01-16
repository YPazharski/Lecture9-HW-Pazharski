package by.PazharskiYury.lesson_11;

public class Lesson11Main {

    public static void main(String[] args) {
        String[][] nullTable = null;
        String[][] tableWithNullRows = new String[][]{
                null,
                null,
                null,
                null
        };

        String[] good4Integers = new String[]{"-45", "65", "08", "-0"};
        String[] good3Integers = new String[]{"66", "90", "4000"};
        String[] bad4Integers = new String[]{"kwa", "65.3", "08,1", ""};
        String[] nulls4 = new String[]{null, null, null, null};

        String[][] tableWithNullElements = new String[][]{nulls4, nulls4, nulls4, nulls4};
        String[][] goodTable = new String[][]{good4Integers, good4Integers, good4Integers, good4Integers};
        String[][] tearedTable = new String[][]{good4Integers, good4Integers, good3Integers, good4Integers};
        String[][] tableWith5Rows = new String[][]{good4Integers, good4Integers, good4Integers, good4Integers, good4Integers};
        String[][] badTable = new String[][]{good4Integers, good4Integers, bad4Integers, good4Integers};

        String[][][] tables = new String[][][]{nullTable, tableWithNullRows, tableWithNullElements, goodTable, tearedTable, tableWith5Rows, badTable};

        for (int i = 0; i < tables.length; i++) {
            System.out.println(System.lineSeparator() + "Processing table with index " + i + "..." + System.lineSeparator());
            try {
                int result = MyArrayProcessor.sumStringNumbersIn4x4Table(tables[i]);
                System.out.println("The result was " + result);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println("EXCEPTION MESSAGE:");
                System.out.println(e.getMessage());
                System.out.println("EXCEPTION STACKTRACE:");
                e.printStackTrace(System.out);
            } catch (NullPointerException e) {
                System.out.println("Well... I wasn't told how to process null!!!");
                System.out.println("EXCEPTION STACKTRACE:");
                e.printStackTrace(System.out);
            } finally {
                System.out.println(System.lineSeparator() + "Finished processing table with index " + i + '.' + System.lineSeparator());
            }
        }

    }

}