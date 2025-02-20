package org.example.practiceproblems.convertlistintoarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Arrays;
import java.util.List;

public class ConvertListIntoArray {
        public static void main(String[] args) {
            // Create a list of Java objects
            List<Person> personList = Arrays.asList(
                    new Person("John", 30),
                    new Person("Alice", 25),
                    new Person("Bob", 35)
            );

            // Convert the list to a JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Serialize list of objects into JSON array
                String jsonArray = objectMapper.writeValueAsString(personList);
                System.out.println("JSON Array: " + jsonArray);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        // Define a simple Person class
        public static class Person {
            private String name;
            private int age;

            // Constructor
            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            // Getters
            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }
    }
