package org.example.handsonpracticeproblems.convertjavaobjectsintoarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ConvertIntoArray {
        public static void main(String[] args) {
            // Create a list of Java objects (Person objects)
            List<Person> personList = Arrays.asList(
                    new Person("satyam", 30),
                    new Person("yogesh", 25),
                    new Person("adarsh", 35)
            );

            // Convert the list to a JSON array using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Serialize list of objects into JSON array
                String jsonArray = objectMapper.writeValueAsString(personList);
                System.out.println("JSON Array: " + jsonArray);
            } catch (Exception e) {
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
