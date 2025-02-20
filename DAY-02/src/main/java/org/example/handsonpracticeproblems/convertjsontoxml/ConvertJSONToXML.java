package org.example.handsonpracticeproblems.convertjsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ConvertJSONToXML {
        public static void main(String[] args) {
            // Example JSON data
            String jsonString = "{ \"name\": \"John\", \"age\": 30, \"email\": \"john@example.com\" }";

            // Create ObjectMapper to parse the JSON
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            try {
                // Convert JSON string to JsonNode
                JsonNode jsonNode = objectMapper.readTree(jsonString);

                // Convert JsonNode to XML and print it
                String xmlString = xmlMapper.writeValueAsString(jsonNode);
                System.out.println("XML Output:");
                System.out.println(xmlString);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
