package org.example.basicproblems.readCSVfileandprintdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String filepath = "src/main/java/org/example/basicproblems/readCSVfileandprintdata/question1CSV.csv";

        try(BufferedReader buffer = new BufferedReader(new FileReader(filepath))){

            String nextLine;

            while((nextLine = buffer.readLine()) != null){
                String[] arr = nextLine.split(",");
                System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
