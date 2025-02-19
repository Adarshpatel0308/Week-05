package org.example.advancedproblems.detectduplicatesinCSVfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/advancedproblems/detectduplicatesinCSVfile/question12.csv"; // Change to your file path

        Set<String> uniqueIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                String id = line[0]; // Assuming ID is in the first column

                if (!uniqueIds.add(id)) {
                    duplicateIds.add(id);
                }
            }

            if (duplicateIds.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate IDs found: " + duplicateIds);
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}