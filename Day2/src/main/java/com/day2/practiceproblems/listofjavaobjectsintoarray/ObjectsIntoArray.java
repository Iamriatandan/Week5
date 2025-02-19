package com.day2.practiceproblems.listofjavaobjectsintoarray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ObjectsIntoArray {
    public static void main(String[] args) {
        try {
            // Create a list of Car objects
            List<Car> cars = Arrays.asList(
                    new Car("Tesla", "Model S", 2022),
                    new Car("BMW", "X5", 2021),
                    new Car("Audi", "A6", 2023)
            );

            // Convert the list to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);

            // Print JSON output
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}