package org.example.intermediateproblems.sortcsvrecordsbycolumn;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.*;

public class SortRecords {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/org/example/intermediateproblems/sortcsvrecordsbycolumn/question7.csv"))) {
            String[] line;
            List<String[]> allRecords = new ArrayList<>();

            // Read all lines from the CSV file and skip the header
            boolean isHeader = true;
            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }
                allRecords.add(line);
            }

            allRecords.sort((record1, record2) -> {
                double salary1 = Double.parseDouble(record1[2]);
                double salary2 = Double.parseDouble(record2[2]);
                return Double.compare(salary2, salary1);  // Sorting in descending order
            });

            // Print top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < Math.min(5, allRecords.size()); i++) {
                String[] employee = allRecords.get(i);
                System.out.println("Name: " + employee[0] + ", Department: " + employee[1] + ", Salary: " + employee[2]);
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }
}
