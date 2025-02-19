package com.day1.csvdatahandling.intermediateproblems.modify;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateSalaries {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\intermediateproblems\\modify\\newdata.csv";
        String updatedFilePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\intermediateproblems\\modify\\updatedfile.csv";
        String target = "IT";
        newSalary(filepath,target,updatedFilePath);

    }

    //Method to update salaries
    public static void newSalary(String filePath , String target,String updatedFilePath){
        try(  BufferedReader reader = new BufferedReader(new FileReader(filePath));
              BufferedWriter writer = new BufferedWriter(new FileWriter(updatedFilePath))){
           String line;
            // reading header
            if((line= reader.readLine())!=null){
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }

            //finding record and updating salary
            while ((line = reader.readLine())!=null){
                String[] values = line.split(",");
                if(values[2].trim().equals(target)){
                    int salary = Integer.parseInt(values[3]);
                    salary =(int) (salary*1.10);
                    values[3] = String.valueOf(salary);
                }
                writer.write(values[0] + "," + values[1] + "," + values[2]+ "," + values[3]);
                writer.newLine();
                System.out.println(values[0] + " " + values[1] + " " + values[2]+ " " + values[3]);
            }
        }
        catch (IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
