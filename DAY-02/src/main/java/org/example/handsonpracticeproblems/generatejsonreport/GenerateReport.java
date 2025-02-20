package org.example.handsonpracticeproblems.generatejsonreport;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {
        // User class to map database records
        public static class User {
            private int id;
            private String name;
            private int age;
            private String email;

            public User(int id, String name, int age, String email) {
                this.id = id;
                this.name = name;
                this.age = age;
                this.email = email;
            }

            // Getters and setters
            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }

        public static void main(String[] args) {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String user = "root"; // Your DB username
            String password = "password"; // Your DB password

            // SQL query to retrieve user records
            String sqlQuery = "SELECT id, name, age, email FROM users";

            // Create an ObjectMapper instance for converting to JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // List to store user records
            List<User> users = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlQuery)) {

                // Iterate over the result set and populate the list of users
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String email = rs.getString("email");

                    // Add user to the list
                    users.add(new User(id, name, age, email));
                }

                // Convert list of users to JSON
                String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);

                // Print the JSON report
                System.out.println("Generated JSON Report:");
                System.out.println(jsonReport);

            } catch (SQLException | com.fasterxml.jackson.core.JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
