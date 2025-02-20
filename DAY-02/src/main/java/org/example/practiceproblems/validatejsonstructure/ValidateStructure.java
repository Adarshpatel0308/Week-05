package org.example.practiceproblems.validatejsonstructure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ValidateStructure {
    public static void main(String[] args) {
        String validJson = "{\"name\": \"Alice\", \"age\": 30}";
        String invalidJson = "{\"name\": \"Alice\", \"age\": 30";

        // Validate valid JSON
        System.out.println("Validating valid JSON:");
        validateJson(validJson);

        // Validate invalid JSON
        System.out.println("\nValidating invalid JSON:");
        validateJson(invalidJson);
    }

    public static void validateJson(String jsonString) {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            JsonNode jsonNode = objectMapper.readTree(jsonString);


            System.out.println("Valid JSON structure.");
        } catch (JsonProcessingException e) {

            System.out.println("Invalid JSON structure.");
        }
    }
}
