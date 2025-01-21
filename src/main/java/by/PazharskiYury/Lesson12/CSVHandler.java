package by.PazharskiYury.Lesson12;

import java.io.*;

public class CSVHandler {

    private static final char SEPARATOR = ';';

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
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, (int) csvFile.length())) {
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
