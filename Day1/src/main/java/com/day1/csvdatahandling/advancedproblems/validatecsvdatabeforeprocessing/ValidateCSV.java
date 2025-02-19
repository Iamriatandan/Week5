package com.day1.csvdatahandling.advancedproblems.validatecsvdatabeforeprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\validatecsvdatabeforeprocessing\\records.csv";
        validate(filePath);
    }

    //Method to validate csv data of email and phone number
    public static void validate(String filePath){

        //regex for email and phone number
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneNumberRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phoneNumberPattern = Pattern.compile(phoneNumberRegex);

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            //header display
            String header = reader.readLine();
            System.out.println(header);

            //reading and validating records
            while((line = reader.readLine())!= null){
                String [] values = line.split(",");

                String email = values[2].trim();
                String phoneNumber = values[3].trim();

                boolean isValidEmail = emailPattern.matcher(email).matches();
                boolean isValidPhoneNumber = phoneNumberPattern.matcher(phoneNumber).matches();



                if(!isValidEmail || !isValidPhoneNumber){
                    System.out.println("Invalid row : " + line);
                    if(!isValidEmail){
                        System.out.println("Invalid email " + email);
                    }
                    if(!isValidPhoneNumber){
                        System.out.println("Invalid phone number : " + phoneNumber);
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println("Error locating file ");
            e.printStackTrace();
        }
    }
}
