package org.example.handsonpracticeproblems.validateemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class ValidateEmail{
    public static void main(String[] args) {
        // JSON to validate
        String json = "{\"email\":\"adarsh@example.com\"}";

        // JSON Schema with email validation
        String schemaJson = "{"
                + "\"type\":\"object\","
                + "\"properties\":{"
                + "\"email\":{\"type\":\"string\",\"format\":\"email\"}"
                + "},"
                + "\"required\":[\"email\"]"
                + "}";

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse the JSON and schema into JsonNode objects
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode schemaNode = objectMapper.readTree(schemaJson);

            // Create a JsonSchemaFactory and generate the schema
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema schema = schemaFactory.getJsonSchema(schemaNode);

            // Validate the JSON against the schema
            ProcessingReport report = schema.validate(jsonNode);

            // Print the validation result
            if (report.isSuccess()) {
                System.out.println("Email is valid!");
            } else {
                System.out.println("Email is NOT valid!");
                report.forEach(message -> System.out.println(message.getMessage()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}