package by.PazharskiYury.Lesson12;

import java.io.*;
import java.util.Arrays;

public class CSVHandler {

    public static final char SEPARATOR = ';';

    public static AppData readFromFile(File csvFile) {
        try (FileReader fileReader = new FileReader(csvFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader, (int) csvFile.length())) {

            char[] charArray = new char[(int) csvFile.length()];
            bufferedReader.read(charArray);
            String[] lines = new String(charArray).split(System.lineSeparator());
            String[] header = lines[0].split(String.valueOf(SEPARATOR));
            Integer[][] data = extractCsvData(lines);
            return new AppData(header, data);
        } catch (IOException e) {
            System.out.println("Could not read the file (" + csvFile.getAbsolutePath() + "). Exception message:");
            System.out.println(e.getMessage());
            System.out.println("Exception stack trace:");
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static boolean writeToFile(AppData appData, File csvFile) {
        try (FileWriter fileWriter = new FileWriter(csvFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String[] header = appData.getHeaderCopy();
            Integer[][] data = appData.getDataCopy();
            String csvString = buildCsvString(header, data);
            bufferedWriter.write(csvString);
            return true;
        } catch (IOException e) {
            System.out.println("Could not write to file (" + csvFile.getAbsolutePath() + "). Exception message:");
            System.out.println(e.getMessage());
            System.out.println("Exception stack trace:");
            e.printStackTrace(System.out);
            return false;
        }
    }

    public static boolean save(AppData data) {
        return writeToFile(data, new File("csv.csv"));
    }

    private static Integer[][] extractCsvData(String[] csvLines) {
        String[][] stringData = Arrays.stream(csvLines)
                .skip(1)
                .map(s -> s.split(String.valueOf(SEPARATOR)))
                .toArray(String[][]::new);

        return Arrays.stream(stringData)
                .map(row -> Arrays.stream(row)
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new))
                .toArray(Integer[][]::new);
    }

    private static String buildCsvString(String[] header, Integer[][] data) {
        StringBuilder writeData = new StringBuilder();
        for (String columnTitle : header) {
            writeData.append(columnTitle).append(SEPARATOR);
        }

        writeData.deleteCharAt(writeData.length() - 1);
        writeData.append(System.lineSeparator());
        for (Integer[] row : data) {
            for (Integer element : row) {
                writeData.append(element).append(SEPARATOR);
            }

            writeData.deleteCharAt(writeData.length() - 1);
            writeData.append(System.lineSeparator());
        }

        writeData.delete(writeData.lastIndexOf(System.lineSeparator()), writeData.length());
        return writeData.toString();
    }

}
