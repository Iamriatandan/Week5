package com.day2.practiceproblems.jsonobjenttoformat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONObjectFormat {
    public static void main(String[] args) {
        try {
            Car car = new Car("BMW", "S16", 2024);

            //CONVERT JSON using jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String carJson = objectMapper.writeValueAsString(car);

            System.out.println(carJson);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
