package org.example.advancedproblems.validateCSVdataBeforeProcessing;

import java.io.*;
import java.util.regex.*;

public class ValidateData {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/advancedproblems/validateCSVdataBeforeProcessing/question8.csv"; // Path to the CSV file

        // Regex patterns for validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String phoneRegex = "^\\d{10}$"; // Exactly 10 digits

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int rowNumber = 0;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                rowNumber++;
                if (isHeader) {
                    // Skip the header row
                    isHeader = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");
                String name = columns[0];
                String email = columns[1];
                String phone = columns[2];

                // Validate email and phone number
                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                // Print error message for invalid rows
                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Invalid row at line " + rowNumber + ": " + line);
                    if (!isEmailValid) {
                        System.out.println("  - Invalid email: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("  - Invalid phone number: " + phone);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}