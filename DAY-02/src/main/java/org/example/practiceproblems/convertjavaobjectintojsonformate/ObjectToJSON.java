package org.example.practiceproblems.convertjavaobjectintojsonformate;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

class Car {
    private String make;
    private String model;
    private int year;

    // Default constructor (required for Jackson)
    public Car() {}

    // Parameterized constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters (required for Jackson)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

public class ObjectToJSON {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Maruti", "TATA", 2022);

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Enable pretty-printing (optional)
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Convert the Car object to JSON string
            String jsonString = objectMapper.writeValueAsString(car);

            // Print the JSON string
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
