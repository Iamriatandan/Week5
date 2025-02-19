package com.day2.handsonpracticeproblems.listofjavaobjectsintoarray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ObjectsIntoArray {
    public static void main(String[] args) {
        try {
            List<Car> cars = Arrays.asList(
                    new Car("Toyota", "Corolla", 2020),
                    new Car("Honda", "Civic", 2019)
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(cars);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
