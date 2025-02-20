package org.example.practiceproblems.readjsonfile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.annotations.SerializedName;

class User {
    private String name;
    private String email;

    // Constructor, Getters, and Setters

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}

public class ReadJSONFIle {
    public static void main(String[] args) {
        // Create a Gson object
        Gson gson = new Gson();

        // Define the path to your JSON file
        String filePath = "src/main/java/org/example/practiceproblems/readjsonfile/question3.json"; // Replace with the actual file path

        try {
            // Reading the JSON file
            FileReader reader = new FileReader(filePath);

            // Deserialize JSON into a JsonObject
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Extract specific fields (name and email) from the JSON object
            String name = jsonObject.get("name").getAsString();
            String email = jsonObject.get("email").getAsString();

            // Output the extracted fields
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
