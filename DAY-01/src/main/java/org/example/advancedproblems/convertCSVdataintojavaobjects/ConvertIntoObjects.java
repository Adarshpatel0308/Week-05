package org.example.advancedproblems.convertCSVdataintojavaobjects;

import java.io.*;
import java.util.*;

public class ConvertIntoObjects {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/advancedproblems/convertCSVdataintojavaobjects/question9.csv"; // Path to the CSV file

        // List to store Student objects
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    // Skip the header row
                    isHeader = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");
                String name = columns[0];
                int age = Integer.parseInt(columns[1]);
                String grade = columns[2];

                // Create a Student object and add it to the list
                students.add(new Student(name, age, grade));
            }

            // Print all Student objects
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Student class to represent a student record
class Student {
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Grade: %s", name, age, grade);
    }
}
