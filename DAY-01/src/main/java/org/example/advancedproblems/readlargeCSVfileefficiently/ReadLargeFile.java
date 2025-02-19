package org.example.advancedproblems.readlargeCSVfileefficiently;

import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/advancedproblems/readlargeCSVfileefficiently/question11.csv"; // Path to the large CSV file
        int chunkSize = 100; // Number of lines to process at a time
        int totalRecordsProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int linesProcessed = 0;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    // Skip the header row
                    isHeader = false;
                    continue;
                }

                // Process the line (e.g., print or analyze)
                System.out.println("Processing: " + line);
                linesProcessed++;
                totalRecordsProcessed++;

                // Process in chunks of 100 lines
                if (linesProcessed == chunkSize) {
                    System.out.println("Processed " + chunkSize + " lines. Total records processed: " + totalRecordsProcessed);
                    linesProcessed = 0; // Reset the counter
                }
            }

            // Process any remaining lines (less than 100)
            if (linesProcessed > 0) {
                System.out.println("Processed " + linesProcessed + " lines. Total records processed: " + totalRecordsProcessed);
            }

            System.out.println("Total records processed: " + totalRecordsProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
