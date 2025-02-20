package org.example.practiceproblems.createJSONobject;

import org.json.JSONObject;
import org.json.JSONArray;

public class CreateObject {
    public static void main(String[] args) {
        // Create a JSON object for a student
        JSONObject student = new JSONObject();

        // Add name and age fields
        student.put("name", "Adarsh Patel");
        student.put("age", 20);

        // Create a JSONArray for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Science");
        subjects.put("History");

        // Add subjects array to the student object
        student.put("subjects", subjects);

        // Print the JSON object
        System.out.println(student.toString());
    }
}
