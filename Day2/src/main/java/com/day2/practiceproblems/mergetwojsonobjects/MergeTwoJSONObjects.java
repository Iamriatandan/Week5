package com.day2.practiceproblems.mergetwojsonobjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeTwoJSONObjects {
    public static void main(String[] args) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();

            //Two json objects as strings
            String json1 = "{ \"name\": \"Ria Tandan\", \"age\": 22 }";
            String json2 = "{ \"email\": \"ria@example.com\", \"city\": \"New Delhi\" }";

            //convert json strings into json root nodes
            JsonNode node1 = objectMapper.readTree(json1);
            JsonNode node2 = objectMapper.readTree(json2);

            //merge json objects
            ObjectNode mergeNode = objectMapper.createObjectNode();
            mergeNode.setAll((ObjectNode) node1);
            mergeNode.setAll((ObjectNode) node2);

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergeNode));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
