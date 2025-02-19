package com.day1.csvdatahandling.advancedproblems.mergetwocsvfiles;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoCsvFiles {
    public static void main(String[] args) {
        String filePath1 = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\mergetwocsvfiles\\student1.csv";
        String filePath2 = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\mergetwocsvfiles\\student2.csv";
        String mergedFile = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\mergetwocsvfiles\\updatedstudentrecord.csv";

        mergeFiles(filePath1, filePath2, mergedFile);
    }

    public static void mergeFiles(String filePath1, String filePath2, String mergeFile) {
        Map<Integer, String[]> studentData = new HashMap<>();

        // Read student1.csv and store data
        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1))) {
            String line;
            reader1.readLine(); // Skip header

            while ((line = reader1.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < 3) continue; // Skip malformed rows

                int id = Integer.parseInt(values[0].trim());
                String name = values[1].trim();
                String age = values[2].trim();

                studentData.put(id, new String[]{name, age, "", ""}); // Empty placeholders for marks & grade
                System.out.println("Loaded from file 1: " + id + " -> " + name + ", " + age);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath1);
            e.printStackTrace();
        }

        // Read student2.csv and merge data
        try (BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
            String line;
            reader2.readLine(); // Skip header

            while ((line = reader2.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < 3) continue; // Skip malformed rows

                int id = Integer.parseInt(values[0].trim());
                String marks = values[1].trim();
                String grade = values[2].trim();

                // Merge if ID exists, otherwise create a new entry
                if (studentData.containsKey(id)) {
                    String[] studentInfo = studentData.get(id);
                    studentData.put(id, new String[]{studentInfo[0], studentInfo[1], marks, grade});
                    System.out.println("Merged ID: " + id + " -> " + studentInfo[0] + ", " + studentInfo[1] + ", " + marks + ", " + grade);
                } else {
                    System.out.println("ID not found in student1.csv: " + id);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath2);
            e.printStackTrace();
        }

        // Write merged data to output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergeFile))) {
            writer.write("ID,Name,Age,Marks,Grade\n");

            for (Map.Entry<Integer, String[]> entry : studentData.entrySet()) {
                writer.write(entry.getKey() + "," + String.join(",", entry.getValue()) + "\n");
            }

            System.out.println("Merged File Successfully!");
        } catch (IOException e) {
            System.out.println("File not merged.");
            e.printStackTrace();
        }
    }
}
