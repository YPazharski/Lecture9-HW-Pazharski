package by.PazharskiYury.Lesson12;

import java.util.Arrays;

public class AppData {

    private final String[] header;
    private final int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
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