package com.day1.csvdatahandling.intermediateproblems.filterrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class FilterRecords {
    public static void main(String[] args) {
       String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\intermediateproblems\\filterrecords\\students.csv";

       qualified(filePath);
    }

    //Method to find qualifying records
    public static void qualified (String filePath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;

            //reading header
            if((line = reader.readLine())!= null){
                System.out.println(line);
            }

            while ((line = reader.readLine())!= null){
                String [] values = line.split(",");
                int marks = Integer.parseInt(values[3]);
                if(marks>=80){
                    System.out.println(values[0] + " " + values[1] + " " + values[2]+ " " + marks );
                }
            }
        }
        catch (IOException e){
            System.out.println("Error Reading file ");
            e.printStackTrace();
        }
    }
}
