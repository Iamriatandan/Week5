package com.day1.csvdatahandling.advancedproblems.duplicaterecords;
import java.util.Set;
import java.util.*;
import java.io.*;

public class DuplicateRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\duplicaterecords\\file.csv";
        duplicate(filePath);
    }

    //Method to remove duplicate records
    public static void duplicate(String filePath) {
        Set<Integer> uniqueIds = new LinkedHashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());

                if (!uniqueIds.add(id)) {  // Maintains order while checking duplicates
                    duplicateRecords.add(line);
                }
            }

            // Print duplicates
            if (duplicateRecords.isEmpty()) {
                System.out.println(" No duplicate records found.");
            } else {
                System.out.println(" Duplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println("Duplicate: " + record);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file!");
            e.printStackTrace();
        }
    }
}
