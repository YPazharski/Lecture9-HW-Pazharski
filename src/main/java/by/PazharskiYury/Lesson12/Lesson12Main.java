package by.PazharskiYury.Lesson12;

import java.io.File;

public class Lesson12Main {

    public static void main(String[] args) {
        String[] header = new String[]{"one", "two", "three"};
        int[][] data = new int[][]{
                {11, 12, 13},
                {21, 22, 23},
                {31, 32, 33}
        };

        AppData appData = new AppData(header, data);
        System.out.println(appData);

        File csv = new File("csv.csv");
        System.out.println(CSVHandler.writeToFile(appData, csv));
        AppData readData = CSVHandler.readFromFile(csv);
        System.out.println(readData);
        System.out.println(CSVHandler.save(readData));
    }

}