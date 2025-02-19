package org.example.basicproblems.readandcountrowsinCSVfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {

        String str = "src/main/java/org/example/basicproblems/readandcountrowsinCSVfile/question3.csv";


            int rowCount = 0; // Counter variable to count rows

            try (BufferedReader br = new BufferedReader(new FileReader(str))) {
                // Read and ignore the header row
                br.readLine();

                // Read the remaining lines and count the rows
                while (br.readLine() != null) {
                    rowCount++;
                }

                // Print the number of records
                System.out.println("Number of records (excluding header): " + rowCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
