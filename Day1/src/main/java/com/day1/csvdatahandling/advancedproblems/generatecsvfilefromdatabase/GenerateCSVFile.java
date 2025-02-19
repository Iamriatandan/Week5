package com.day1.csvdatahandling.advancedproblems.generatecsvfilefromdatabase;
import java.util.*;
import java.io.*;
public class GenerateCSVFile {
    public void generateCSVReport(String inputFilePath, String outputFilePath) {
        List<String[]> employeeRecords = readEmployeeData(inputFilePath);
        writeToCSV(employeeRecords, outputFilePath);
    }

    private List<String[]> readEmployeeData(String filePath) {
        List<String[]> records = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

    private void writeToCSV(List<String[]> records, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing headers
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Writing records
            for (String[] record : records) {
                writer.write(String.join(",", record));
                writer.newLine();
            }

            System.out.println("CSV Report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\generatecsvfilefromdatabase\\input.csv";
        String outputFilePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\generatecsvfilefromdatabase\\output.csv";

        GenerateCSVFile reportGenerator = new GenerateCSVFile();
        reportGenerator.generateCSVReport(inputFilePath, outputFilePath);
    }
}
