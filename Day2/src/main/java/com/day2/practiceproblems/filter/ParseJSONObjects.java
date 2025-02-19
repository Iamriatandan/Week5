package com.day2.practiceproblems.filter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.stream.Collectors;

public class ParseJSONObjects {

        public static void main(String[] args) {
            String jsonArray = """
        [
            { "name": "Ria Tandan", "age": 22, "email": "ria@example.com" },
            { "name": "John Doe", "age": 30, "email": "john@example.com" },
            { "name": "Jane Smith", "age": 28, "email": "jane@example.com" }
        ]
        """;

            try {
                // Convert JSON to List of Person objects
                ObjectMapper objectMapper = new ObjectMapper();
                List<Person> persons = objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});

                // Filter persons with age > 25
                List<Person> filteredPersons = persons.stream()
                        .filter(person -> person.getAge() > 25)
                        .collect(Collectors.toList());

                // Print filtered list
                filteredPersons.forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
