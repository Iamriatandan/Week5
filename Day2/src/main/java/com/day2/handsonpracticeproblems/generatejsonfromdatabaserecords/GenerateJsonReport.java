package com.day2.handsonpracticeproblems.generatejsonfromdatabaserecords;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class GenerateJsonReport {
    public static void main(String[] args) {
        // Sample data (Mock database records)
        List<Map<String, Object>> employees = new ArrayList<>();

        Map<String, Object> emp1 = new HashMap<>();
        emp1.put("id", 101);
        emp1.put("name", "John Doe");
        emp1.put("age", 30);
        emp1.put("department", "IT");

        Map<String, Object> emp2 = new HashMap<>();
        emp2.put("id", 102);
        emp2.put("name", "Alice Smith");
        emp2.put("age", 28);
        emp2.put("department", "HR");

        Map<String, Object> emp3 = new HashMap<>();
        emp3.put("id", 103);
        emp3.put("name", "Bob Johnson");
        emp3.put("age", 35);
        emp3.put("department", "Finance");

        // Add employees to list
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        // Convert to JSON and save to a file
        generateJsonReport(employees, "employee_report.json");
    }

    public static void generateJsonReport(List<Map<String, Object>> data, String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
            System.out.println(" JSON Report Generated: " + fileName);
        } catch (IOException e) {
            System.err.println(" Error writing JSON file: " + e.getMessage());
        }
    }
}
