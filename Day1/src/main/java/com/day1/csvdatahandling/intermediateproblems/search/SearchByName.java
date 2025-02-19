package com.day1.csvdatahandling.intermediateproblems.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchByName {
    public static void main(String[] args) {
         String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\intermediateproblems\\search\\data.csv";
        searchByName(filePath,"Emily");
    }

    //Method to find employee by name and print their department and salary
    public static void searchByName(String filePath,String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            //reading header
            if ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            //initializing that employee is not yet found
            boolean found = false;
            //finding record
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values[1].trim().equals(target)) {
                    System.out.println(values[1] + " : " + " department : " + values[2] + " Salary :  " + values[3]);
                    found=true;
                }
            }
            if(!found){
                System.out.println("No record by name : " + target);
            }
        } catch (IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
