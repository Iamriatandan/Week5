package com.day2.handsonpracticeproblems.csvdataintojson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVIntoJson {
    public static void main(String[] args) throws IOException {
        File csvFile = new File("data.csv");

        // Define CSV Schema (Auto-detects headers)
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        // Create CsvMapper
        CsvMapper csvMapper = new CsvMapper();

        // Read CSV into List of Maps
        MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvFile);

        List<Map<String, String>> jsonList = it.readAll();

        // Convert to JSON
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList);

        // Print JSON Output
        System.out.println(json);
    }
}
