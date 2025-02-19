package org.example.basicproblems.writedatatoCSVfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
    public static void main(String[] args) {

        String filepath = "src/main/java/org/example/basicproblems/writedatatoCSVfile.csv";

        try(BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath))){

            buffer.write(" ID ,Name , Age ,Marks ");
            buffer.write("1 ,Harsh , 21 , 45");
            buffer.write("1 ,adarsh , 20 , 49");
            buffer.write("1 ,satyam , 28 , 51");

            System.out.println("CSV File written Successfully! ");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    }
