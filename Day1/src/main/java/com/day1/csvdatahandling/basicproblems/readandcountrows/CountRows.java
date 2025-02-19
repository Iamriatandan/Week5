package com.day1.csvdatahandling.basicproblems.readandcountrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\basicproblems\\readandcountrows\\records.csv";

        int rows = countRows(filePath);
        System.out.println("Total no of rows is : " + rows);
    }

    //Method to count and Return rows
    public static int countRows(String filePath){
        int count =0;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            //reading header row
            if((line = reader.readLine())!= null){
                System.out.println(line);
            }

            //reading records and counting rows

            while ((line = reader.readLine())!=null){
                String [] values = line.split(",");
                count++;
                System.out.println(values[0]+ " "+ values[1]+ " " +
                        values[2]+ " " + values[3]);
            }
        }
        catch (IOException e){
            System.out.println("Error Reading file ");
            e.printStackTrace();
        }
        return count;
    }
}
