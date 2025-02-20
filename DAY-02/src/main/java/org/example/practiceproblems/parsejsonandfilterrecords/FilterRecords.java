package org.example.practiceproblems.parsejsonandfilterrecords;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class FilterRecords {
        public static void main(String[] args) {
            // Sample JSON string (Array of objects)
            String jsonString = "[{\"name\":\"John\",\"age\":30},{\"name\":\"Alice\",\"age\":22},{\"name\":\"Bob\",\"age\":35}]";

            // Create ObjectMapper to parse the JSON
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                // Convert JSON string to JsonNode (Tree Model)
                JsonNode rootNode = objectMapper.readTree(jsonString);

                // Create a list to store the filtered records
                List<JsonNode> filteredRecords = new ArrayList<>();

                // Iterate through the array and filter based on age > 25
                Iterator<JsonNode> elements = rootNode.elements();
                while (elements.hasNext()) {
                    JsonNode person = elements.next();
                    int age = person.get("age").asInt();
                    if (age > 25) {
                        filteredRecords.add(person);
                    }
                }

                // Print the filtered records
                System.out.println("Filtered records (age > 25): ");
                for (JsonNode record : filteredRecords) {
                    System.out.println(record.toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
