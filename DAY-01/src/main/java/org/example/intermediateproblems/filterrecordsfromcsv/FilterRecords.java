package org.example.intermediateproblems.filterrecordsfromcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {

        String input = "src/main/java/org/example/intermediateproblems/filterrecordsfromcsv/question4.csv";

        try(CSVReader reader = new CSVReader(new FileReader(input))){

            reader.readNext();

            String[] line;
            while((line = reader.readNext()) != null){
                int marks = Integer.parseInt(line[2]);

                if(marks >80){
                    System.out.println(line[0]+" "+marks);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
