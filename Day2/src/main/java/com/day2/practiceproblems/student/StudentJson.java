package com.day2.practiceproblems.student;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
    public static void main(String[] args) {
        // Creating a JSON Object for Student
        JSONObject student = new JSONObject();
        student.put("name", "Ria Tandan");
        student.put("age", 22);

        // Creating an array of subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Computer Science");
        subjects.put("Physics");

        // Adding subjects array to student object
        student.put("subjects", subjects);

        // Printing the JSON object
        System.out.println(student.toString(4)); // Pretty print with indentation
    }
}
