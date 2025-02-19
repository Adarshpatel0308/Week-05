package org.example.advancedproblems.mergetwoCSVfiles;

import java.io.*;
import java.util.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String file1Path = "src/main/java/org/example/advancedproblems/mergetwoCSVfiles/question10one.csv"; // Path to the first CSV file
        String file2Path = "src/main/java/org/example/advancedproblems/mergetwoCSVfiles/question10two.csv"; // Path to the second CSV file
        String outputFilePath = "src/main/java/org/example/advancedproblems/mergetwoCSVfiles/question10output.csv"; // Path to the output CSV file

        // Map to store student details (ID as the key)
        Map<String, Student> students = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader br2 = new BufferedReader(new FileReader(file2Path));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Read and process students1.csv
            String line;
            boolean isHeader1 = true;
            while ((line = br1.readLine()) != null) {
                if (isHeader1) {
                    // Skip the header row
                    isHeader1 = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");
                String id = columns[0];
                String name = columns[1];
                int age = Integer.parseInt(columns[2]);

                // Create a Student object and add it to the map
                students.put(id, new Student(id, name, age));
            }

            // Read and process students2.csv
            boolean isHeader2 = true;
            while ((line = br2.readLine()) != null) {
                if (isHeader2) {
                    // Skip the header row
                    isHeader2 = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");
                String id = columns[0];
                int marks = Integer.parseInt(columns[1]);
                String grade = columns[2];

                // Update the Student object with marks and grade
                if (students.containsKey(id)) {
                    Student student = students.get(id);
                    student.setMarks(marks);
                    student.setGrade(grade);
                }
            }

            // Write the merged data to the output file
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            for (Student student : students.values()) {
                bw.write(student.toString());
                bw.newLine();
            }

            System.out.println("Merged data saved to: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Student class to represent a student record
class Student {
    private String id;
    private String name;
    private int age;
    private int marks;
    private String grade;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%d,%d,%s", id, name, age, marks, grade);
    }
}