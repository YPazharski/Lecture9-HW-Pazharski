package by.PazharskiYury.Lesson12;

import java.util.Arrays;
import java.util.Objects;

public class AppData {

    private final String[] header;
    private final int[][] data;

    /**
     * @param header Table header. Must be NON-NULL! As well as all it's elements.
     * @param data   Table data. Must be NON-NULL! As well as all it's sub-arrays. All sub-arrays must be the same length as the header.
     */
    public AppData(String[] header, int[][] data) {
        checkHeader(header);
        checkData(data, header.length);
        this.header = header;
        this.data = data;
    }

    private void checkData(int[][] data, int headerLength) {
        Objects.requireNonNull(data, "Data must be non-null!");
        for (int[] intArray : data) {
            Objects.requireNonNull(intArray, "Data rows must be non-null!");
            if (intArray.length != headerLength) {
                throw new AppDataFormatException("All data rows must be the same length the header is.");
            }
        }
    }

    private void checkHeader(String[] header) {
        Objects.requireNonNull(header, "Header must be non-null!");
        for (String string : header) {
            Objects.requireNonNull(string, "Header elements must be non-null!");
        }
    }

    public String[] getHeaderCopy() {
        return Arrays.copyOf(header, header.length);
    }

    public int[][] getDataCopy() {
        return Arrays.stream(data).map(a -> Arrays.copyOf(a, a.length)).toArray(int[][]::new);
    }

    @Override
    public String toString() {
        return "\n~APP DATA~\n" +
                Arrays.toString(header) + System.lineSeparator()
                + Arrays.deepToString(data).replace("],", "\n") + System.lineSeparator()
                + "~end of app data~\n\n";
    }

}