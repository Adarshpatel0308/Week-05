package org.example.intermediateproblems.searchforrecordincsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {

        String target = "satyam";
        String input = "src/main/java/org/example/intermediateproblems/searchforrecordincsv/question5.csv";

        try(CSVReader reader = new CSVReader(new FileReader(input))){
            String[] line;
            while((line = reader.readNext()) != null){

                String str = line[0];
                if(str.equalsIgnoreCase(target)){
                    System.out.println(line[0]+" "+line[1]+" "+line[2]);
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
