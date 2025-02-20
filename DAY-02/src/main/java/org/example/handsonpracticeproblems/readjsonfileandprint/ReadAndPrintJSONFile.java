package org.example.handsonpracticeproblems.readjsonfileandprint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class ReadAndPrintJSONFile {
        public static void main(String[] args) {
            // Path to your JSON file
            String filePath = "src/main/java/org/example/handsonpracticeproblems/readjsonfileandprint/handsonquestion2.json";

            // Create ObjectMapper to read JSON
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                // Read the JSON file into a JsonNode
                JsonNode rootNode = objectMapper.readTree(new File(filePath));

                // Check if the root node is an object (it could also be an array)
                if (rootNode.isObject()) {
                    // Iterate through all fields (key-value pairs)
                    Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
                    while (fields.hasNext()) {
                        Entry<String, JsonNode> field = fields.next();
                        String key = field.getKey();  // Get key
                        JsonNode value = field.getValue();  // Get value
                        System.out.println("Key: " + key + ", Value: " + value);
                    }
                } else {
                    System.out.println("The JSON root is not an object.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
