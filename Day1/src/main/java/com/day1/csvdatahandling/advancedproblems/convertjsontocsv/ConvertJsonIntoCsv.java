package com.day1.csvdatahandling.advancedproblems.convertjsontocsv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class ConvertJsonIntoCsv {

    // Convert JSON to CSV
    public void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = Arrays.asList(objectMapper.readValue(new File(jsonFilePath), Student[].class));

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                // Write CSV header
                writer.writeNext(new String[]{"ID", "Name", "Age", "Grade"});

                // Write CSV data
                for (Student student : students) {
                    writer.writeNext(new String[]{
                            String.valueOf(student.getId()),
                            student.getName(),
                            String.valueOf(student.getAge()),
                            student.getGrade()
                    });
                }
            }

            System.out.println("CSV file generated from JSON successfully: " + csvFilePath);

        } catch (IOException e) {
            System.err.println(" Error converting JSON to CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Convert CSV to JSON
    public void csvToJson(String csvFilePath, String jsonFilePath) {
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> records = csvReader.readAll();
            List<Student> students = new ArrayList<>();

            // Validate CSV content
            if (records.isEmpty()) {
                System.err.println(" The CSV file is empty: " + csvFilePath);
                return;
            }

            // Extract headers dynamically
            String[] headers = records.get(0);
            if (headers.length != 4) {
                System.err.println("CSV does not have expected columns! Expected: ID, Name, Age, Grade");
                return;
            }

            // Process data rows
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                if (row.length < 4) {
                    System.err.println("Skipping invalid row: " + Arrays.toString(row));
                    continue;
                }

                Student student = new Student(
                        Integer.parseInt(row[0].trim()),
                        row[1].trim(),
                        Integer.parseInt(row[2].trim()),
                        row[3].trim()
                );
                students.add(student);
            }

            // Write JSON output
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);

            System.out.println(" JSON file generated from CSV successfully: " + jsonFilePath);

        } catch (IOException | CsvException e) {
            System.err.println(" Error converting CSV to JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConvertJsonIntoCsv converter = new ConvertJsonIntoCsv();

        // Define file paths
        String jsonFilePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\convertjsontocsv\\student1.json";
        String csvFilePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\convertjsontocsv\\studenttojson.csv";

        String csvFilePathForJson = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\convertjsontocsv\\studenttojson2.csv";
        String jsonFilePathForCsv = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\convertjsontocsv\\student2.json";

        // Convert JSON to CSV
        converter.jsonToCsv(jsonFilePath, csvFilePath);

        // Convert CSV back to JSON
        converter.csvToJson(csvFilePathForJson, jsonFilePathForCsv);
    }
}
