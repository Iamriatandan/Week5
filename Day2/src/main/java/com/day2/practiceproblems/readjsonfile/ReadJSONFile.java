package com.day2.practiceproblems.readjsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSONFile {
    public static void main(String[] args) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            // Read JSON file into a JsonNode object
            JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day2\\src\\main\\java\\com\\day2\\practiceproblems\\readjsonfile\\data.json"));

            //extract specific fields
            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            System.out.println("Name : " + name);
            System.out.println("email : " + email);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
