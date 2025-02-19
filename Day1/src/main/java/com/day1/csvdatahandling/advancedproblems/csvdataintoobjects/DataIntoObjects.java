package com.day1.csvdatahandling.advancedproblems.csvdataintoobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataIntoObjects {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\csvdataintoobjects\\studentdata.csv";

        dataObjects(filePath);
    }

    // Method to read CSV data and convert it into Student objects
    public static void dataObjects(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read header
            String header = reader.readLine();
            System.out.println(header);

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length != 5) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                try {
                    // Convert CSV row into Student object
                    int id = Integer.parseInt(values[0].trim());
                    String name = values[1].trim();
                    int rollNo = Integer.parseInt(values[2].trim());
                    String email = values[3].trim();
                    String grade = values[4].trim();

                    students.add(new Student(id, name, rollNo, email, grade));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping row with invalid numbers: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error Locating File ");
            e.printStackTrace();
        }

        // Print all student objects
        System.out.println("\nStudent List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
