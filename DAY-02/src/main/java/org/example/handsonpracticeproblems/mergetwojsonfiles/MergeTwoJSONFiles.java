package org.example.handsonpracticeproblems.mergetwojsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeTwoJSONFiles {
        public static void main(String[] args) {
            // File paths for the two JSON files
            String filePath1 = "src/main/java/org/example/handsonpracticeproblems/mergetwojsonfiles/handsonquestion5file1.json";
            String filePath2 = "src/main/java/org/example/handsonpracticeproblems/mergetwojsonfiles/handsonquestion5file2.json";

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                // Read both JSON files into JsonNode objects
                JsonNode jsonNode1 = objectMapper.readTree(new File(filePath1));
                JsonNode jsonNode2 = objectMapper.readTree(new File(filePath2));

                // Merge the two JsonNode objects
                JsonNode mergedNode = mergeJsonNodes(jsonNode1, jsonNode2);

                // Print the merged JSON object
                System.out.println("Merged JSON: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to merge two JsonNode objects
        public static JsonNode mergeJsonNodes(JsonNode node1, JsonNode node2) {
            // If node1 is not an object, return node2 as the result
            if (!node1.isObject()) {
                return node2;
            }

            // If node2 is an object, we merge its fields into node1
            if (node2.isObject()) {
                node2.fieldNames().forEachRemaining(fieldName -> {
                    JsonNode value = node2.get(fieldName);
                    ((ObjectNode) node1).set(fieldName, value); // Merging field from node2 into node1
                });
            }
            return node1;
        }
    }
