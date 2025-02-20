package org.example.handsonpracticeproblems.filterjsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class FilterData {
        public static void main(String[] args) {
            // Path to your JSON file
            String filePath = "src/main/java/org/example/handsonpracticeproblems/filterjsondata/handsonquestion3.json";

            // Create ObjectMapper to read JSON
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                // Read the JSON file into a JsonNode (tree model)
                JsonNode rootNode = objectMapper.readTree(new File(filePath));

                // Check if the root node is an array
                if (rootNode.isArray()) {
                    // Iterate through the array and filter based on age > 25
                    for (JsonNode userNode : rootNode) {
                        int age = userNode.get("age").asInt();  // Get the "age" field
                        if (age > 25) {
                            // Print the user's details if the age is greater than 25
                            System.out.println("Name: " + userNode.get("name").asText());
                            System.out.println("Age: " + userNode.get("age").asInt());
                            System.out.println("Email: " + userNode.get("email").asText());
                            System.out.println("-------------");
                        }
                    }
                } else {
                    System.out.println("Root is not an array.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
