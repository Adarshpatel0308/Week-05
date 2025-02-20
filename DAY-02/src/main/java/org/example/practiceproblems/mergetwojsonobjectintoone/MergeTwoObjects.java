package org.example.practiceproblems.mergetwojsonobjectintoone;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeTwoObjects {
        public static void main(String[] args) {
            // Sample JSON strings
            String json1 = "{\"name\": \"adarsh\", \"age\": 25}";
            String json2 = "{\"email\": \"adarshpatel88899@gmail.com\", \"city\": \"Narmadapuram\"}";

            try {
                // Create ObjectMapper object to read and write JSON
                ObjectMapper objectMapper = new ObjectMapper();

                // Parse the JSON strings into JsonNode instances
                JsonNode jsonNode1 = objectMapper.readTree(json1);
                JsonNode jsonNode2 = objectMapper.readTree(json2);

                // Cast JsonNode to ObjectNode to modify the data
                ObjectNode objectNode1 = (ObjectNode) jsonNode1;

                // Merge jsonNode2 into objectNode1
                objectNode1.setAll((ObjectNode) jsonNode2);

                // Output the merged JSON
                System.out.println("Merged JSON: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode1));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
