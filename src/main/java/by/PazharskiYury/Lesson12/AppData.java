package by.PazharskiYury.Lesson12;

import java.util.Arrays;

public class AppData {

    private final String[] header;
    private final Integer[][] data;

    public AppData(String[] header, Integer[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeaderCopy() {
        return Arrays.copyOf(header, header.length);
    }

    public Integer[][] getDataCopy() {
        return Arrays.stream(data).map(a -> Arrays.copyOf(a, a.length)).toArray(Integer[][]::new);
    }

    @Override
    public String toString() {
        return "\n~APP DATA~\n" +
                Arrays.toString(header) + System.lineSeparator()
                + Arrays.deepToString(data).replace("],", "\n") + System.lineSeparator()
                + "~end of app data~\n\n";
    }

}