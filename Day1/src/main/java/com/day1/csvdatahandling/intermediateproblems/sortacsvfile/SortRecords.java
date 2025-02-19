package com.day1.csvdatahandling.intermediateproblems.sortacsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\intermediateproblems\\sortacsvfile\\data.csv";
        sortBySalaries(filePath);
    }

    // Method to sort csv file in descending order of salaries
    public static void sortBySalaries(String filePath) {
        List<String[]> sortedValues = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reading header
            String header = reader.readLine();
            System.out.println(header);


            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                sortedValues.add(values);
            }

            sortedValues.sort((a, b) -> Integer.parseInt(b[3].trim()) - Integer.parseInt(a[3].trim()));

            Iterator<String[]> iterator = sortedValues.iterator();
            int count = 0;
            while (iterator.hasNext() && count < 5) {
                String[] employee = iterator.next();
                System.out.println(String.join(", ", employee));
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error locating file");
            e.printStackTrace();
        }
    }
}
