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
            int[][] data = extractCsvData(lines);
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
            int[][] data = appData.getDataCopy();
            String csvText = buildCsvText(header, data);
            bufferedWriter.write(csvText);
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

    private static int[][] extractCsvData(String[] csvLines) {
        String[][] stringData = Arrays.stream(csvLines)
                .skip(1)
                .map(s -> s.split(String.valueOf(SEPARATOR)))
                .toArray(String[][]::new);

        int[][] result = new int[stringData.length][stringData[0].length];
        for (int i = 0; i < stringData.length; i++) {
            for (int j = 0; j < stringData[i].length; j++) {
                result[i][j] = Integer.parseInt(stringData[i][j]);
            }
        }

        return result;
    }

    private static String buildCsvText(String[] header, int[][] data) {
        StringBuilder writeData = new StringBuilder();
        appendCsvLine(writeData, header);
        writeData.append(System.lineSeparator());
        int i = 0;
        while (i < data.length - 1) {
            appendCsvLine(writeData, data[i]);
            writeData.append(System.lineSeparator());
            i++;
        }

        appendCsvLine(writeData, data[i]);
        return writeData.toString();
    }

    private static void appendCsvLine(StringBuilder stringBuilder, String[] csvLine) {
        int i = 0;
        while (i < csvLine.length - 1) {
            stringBuilder.append(csvLine[i]).append(SEPARATOR);
            i++;
        }

        stringBuilder.append(csvLine[i]);
    }

    private static void appendCsvLine(StringBuilder stringBuilder, int[] csvLine) {
        int i = 0;
        while (i < csvLine.length - 1) {
            stringBuilder.append(csvLine[i]).append(SEPARATOR);
            i++;
        }

        stringBuilder.append(csvLine[i]);
    }

}