package by.PazharskiYury.Lesson12;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class CSVHandler {

    public static final char SEPARATOR = ';';

    public static AppData readFromFile(File csvFile) {
        try (FileReader fileReader = new FileReader(csvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader, (int) csvFile.length())) {
            char[] charArray = new char[(int) csvFile.length()];
            bufferedReader.read(charArray);
            String[] lines = new String(charArray).split(System.lineSeparator());
            String[] header = lines[0].split(String.valueOf(SEPARATOR));
            String[][] stringData = Arrays.stream(lines).skip(1).map(s -> s.split(String.valueOf(SEPARATOR))).toArray(String[][]::new);
            Integer[][] data = Arrays.stream(stringData).map(row -> Arrays.stream(row).map(Integer::parseInt).toArray(Integer[]::new)).toArray(Integer[][]::new);
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
            bufferedWriter.write(writeData.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Could not write to file (" + csvFile.getAbsolutePath() + "). Exception message:");
            System.out.println(e.getMessage());
            System.out.println("Exception stack trace:");
            e.printStackTrace(System.out);
            return false;
        }
    }

}
