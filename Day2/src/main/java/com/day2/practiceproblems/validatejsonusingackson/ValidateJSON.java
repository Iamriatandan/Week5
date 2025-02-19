package com.day2.practiceproblems.validatejsonusingackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Ria Tandan\", \"email\": \"ria@example.com\" }";  // Valid JSON

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);  // Parse JSON

            System.out.println("JSON is valid!");
        } catch (Exception e) {
            System.out.println(" Invalid JSON: " + e.getMessage());
        }

    }
}
