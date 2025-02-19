package org.example.intermediateproblems.modifycsvfile;

import java.io.*;

public class ModifyFile {
    public static void main(String[] args) {
        String inputFilePath = "src/main/java/org/example/intermediateproblems/modifycsvfile/question6.csv"; // Input CSV file
        String outputFilePath = "src/main/java/org/example/intermediateproblems/modifycsvfile/question6two.csv"; // Output CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean isHeader = true;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    // Write the header to the output file
                    bw.write(line);
                    bw.newLine();
                    isHeader = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");
                String name = columns[0];
                String department = columns[1];
                double salary = Double.parseDouble(columns[2]);

                // Check if the employee is in the "IT" department
                if (department.equalsIgnoreCase("IT")) {
                    // Increase salary by 10%
                    salary *= 1.10;
                }

                // Write the updated record to the output file
                bw.write(name + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("Updated records saved to: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
