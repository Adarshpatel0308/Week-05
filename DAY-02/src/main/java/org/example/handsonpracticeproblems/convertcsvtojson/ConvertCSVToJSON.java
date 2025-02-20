package org.example.handsonpracticeproblems.convertcsvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertCSVToJSON {
    public static void main(String[] args) {
        // Path to the CSV file
        String csvFilePath = "src/main/java/org/example/handsonpracticeproblems/convertcsvtojson/fileCSV.csv";
        // Path to the output JSON file
        String jsonFilePath = "src/main/java/org/example/handsonpracticeproblems/convertcsvtojson/output.json";

        // Read CSV and convert to JSON
        try {
            List<Map<String, String>> data = readCSV(csvFilePath);
            writeJSON(data, jsonFilePath);
            System.out.println("CSV data successfully converted to JSON!");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    // Read CSV file and convert to a list of maps
    private static List<Map<String, String>> readCSV(String csvFilePath) throws IOException, CsvException {
        List<Map<String, String>> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            // Read the header (first row)
            String[] headers = reader.readNext();

            // Read the remaining rows
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Map<String, String> row = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], nextLine[i]);
                }
                data.add(row);
            }
        }

        return data;
    }

    // Write the list of maps to a JSON file
    private static void writeJSON(List<Map<String, String>> data, String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            objectMapper.writeValue(fileWriter, data);
        }
    }
}