package com.day2.practiceproblems.listofjavaobjectsintoarray;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Car {
        @JsonProperty("brand")
        private String brand;

        @JsonProperty("model")
        private String model;

        @JsonProperty("year")
        private int year;

        // Constructor
        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        // Getters & Setters
        public String getBrand() { return brand; }
        public String getModel() { return model; }
        public int getYear() { return year; }

        public void setBrand(String brand) { this.brand = brand; }
        public void setModel(String model) { this.model = model; }
        public void setYear(int year) { this.year = year; }
    }