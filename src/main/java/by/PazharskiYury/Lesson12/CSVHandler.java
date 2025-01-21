package by.PazharskiYury.Lesson12;

import java.io.*;
import java.util.Arrays;

public class CSVHandler {

    public static final char SEPARATOR = ';';

    public static boolean readFromFile(File csvFile, AppData appData) {
        try (FileReader fileReader = new FileReader(csvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader, (int) csvFile.length())) {
            return true;
        } catch (IOException e) {
            System.out.println("Could not read the file (" + csvFile.getAbsolutePath() + "). Exception message:");
            System.out.println(e.getMessage());
            System.out.println("Exception stack trace:");
            e.printStackTrace(System.out);
            return false;
        }
    }

    public static boolean writeToFile(AppData appData, File csvFile) {
        try (FileWriter fileWriter = new FileWriter(csvFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String[] header = appData.getHeaderCopy();
            int[][] data = appData.getDataCopy();
            StringBuilder writeData = new StringBuilder();
            for (String columnTitle : header) {
                writeData.append(columnTitle).append(SEPARATOR);
            }

            writeData.deleteCharAt(writeData.length() - 1);
            writeData.append(System.lineSeparator());
            for (int[] row : data) {
                for (int element : row) {
                    writeData.append(element).append(SEPARATOR);
                }

                writeData.deleteCharAt(writeData.length() - 1);
                writeData.append(System.lineSeparator());
            }

            writeData.delete(writeData.lastIndexOf(System.lineSeparator()), writeData.length() - 1);
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
