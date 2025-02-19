package com.day2.handsonpracticeproblems.mergetwojsonfilesintosingleobject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeFilesIntoObject {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Load both JSON files
        JsonNode json1 = mapper.readTree(new File("C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day2\\src\\main\\java\\com\\day2\\handsonpracticeproblems\\mergetwojsonfilesintosingleobject\\file1.json"));
        JsonNode json2 = mapper.readTree(new File("C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day2\\src\\main\\java\\com\\day2\\handsonpracticeproblems\\mergetwojsonfilesintosingleobject\\file2.json"));

        // Merge JSON files
        JsonNode mergedJson = mergeJson(json1, json2);

        // Print the merged JSON
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
    }

    private static JsonNode mergeJson(JsonNode mainNode, JsonNode updateNode) {
        if (mainNode.isObject() && updateNode.isObject()) {
            ObjectNode mergedNode = (ObjectNode) mainNode.deepCopy();
            updateNode.fields().forEachRemaining(entry -> mergedNode.set(entry.getKey(), entry.getValue()));
            return mergedNode;
        }
        return mainNode;
    }
}
