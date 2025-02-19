package com.day2.handsonpracticeproblems.readandprint;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadAndPrint {
        public static void main(String[] args) {
            try {
                // Read JSON file
                String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day2\\src\\main\\java\\com\\day2\\handsonpracticeproblems\\readandprint\\data.json")));

                // Convert to JSONObject
                JSONObject jsonObject = new JSONObject(content);

                // Iterate over keys and print values
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    System.out.println(key + " : " + jsonObject.get(key));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
