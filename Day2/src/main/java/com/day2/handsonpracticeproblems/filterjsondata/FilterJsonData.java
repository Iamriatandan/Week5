package com.day2.handsonpracticeproblems.filterjsondata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
public class FilterJsonData {
    public static void main(String[] args) {
        String jsonArray = """
            [
                { "name": "Ria", "age": 22, "email": "ria@example.com" },
                { "name": "John", "age": 30, "email": "john@example.com" },
                { "name": "Jane", "age": 28, "email": "jane@example.com" }
            ]
            """;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(jsonArray, new TypeReference<List<User>>() {});

            // Filter users where age > 25
            List<User> filteredUsers = users.stream()
                    .filter(user -> user.age > 25)
                    .collect(Collectors.toList());

            // Print filtered users
            filteredUsers.forEach(user -> System.out.println(user.name + " - " + user.age));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
