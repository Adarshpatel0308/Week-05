package org.example.advancedproblems.generateCSVreportfromdatabase;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateCSVReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://your_host:your_port/your_database"; // Replace with your DB URL
        String user = "your_username";  // Replace with your DB username
        String password = "your_password"; // Replace with your DB password
        String csvFile = "src/main/java/org/example/advance_problems/generate_csv_datanase/employees_report.csv";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             FileWriter writer = new FileWriter(csvFile)) {

            String query = "SELECT id, name, department, salary FROM employees";
            ResultSet rs = stmt.executeQuery(query);

            // Writing header
            writer.append("Employee ID,Name,Department,Salary\n");

            // Writing data
            while (rs.next()) {
                writer.append(rs.getInt("id") + ",");
                writer.append(rs.getString("name") + ",");
                writer.append(rs.getString("department") + ",");
                writer.append(rs.getDouble("salary") + "\n");
            }

            System.out.println("CSV report generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
