package com.day1.csvdatahandling.advancedproblems.readlargecsvfile;
import java.util.*;
import java.io.*;
public class LargeCsvFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\readlargecsvfile\\largefile.csv";

        readLargeCSV(filePath);
    }

    public static void readLargeCSV(String filePath) {
        int batchSize = 100;  // Process 100 lines at a time
        int count = 0;        // Total number of records processed
        int batchCount = 0;   // Number of batches processed

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip Header
            String header = reader.readLine();
            System.out.println("Header: " + header);

            while ((line = reader.readLine()) != null) {
                count++; // Increase record count

                // Process line (Example: Just printing)
                System.out.println("Processing: " + line);

                // If batch of 100 is completed
                if (count % batchSize == 0) {
                    batchCount++;
                    System.out.println("✅ Processed " + count + " records so far...");
                }
            }

            System.out.println(" Finished processing total records: " + count);
        } catch (IOException e) {
            System.out.println("Error reading the file!");
            e.printStackTrace();
        }
    }
}
