package com.day2.handsonpracticeproblems.convertjsonintoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // Read JSON from a file
        JsonNode jsonNode = jsonMapper.readTree(new File("C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day2\\src\\main\\java\\com\\day2\\handsonpracticeproblems\\convertjsonintoxml\\data.json"));

        // Wrap JSON inside a root node for XML conversion
        String wrappedJson = "{ \"root\": " + jsonNode.toString() + " }";
        JsonNode wrappedNode = jsonMapper.readTree(wrappedJson);

        // Convert JSON to XML
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(wrappedNode);

        System.out.println(xml);
    }
}
