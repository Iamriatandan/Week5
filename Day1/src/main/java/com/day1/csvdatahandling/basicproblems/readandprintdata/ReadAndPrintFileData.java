package com.day1.csvdatahandling.basicproblems.readandprintdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintFileData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\basicproblems\\readandprintdata\\students.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

          String line;

         //Read and print the reader
            if((line = br.readLine())!= null){
                System.out.println(line);
                System.out.println();
            }



            while ((line = br.readLine())!= null){
                String [] values =  line.split(",");
                System.out.println("Roll no.:" + values[0] + " Name: " + values[1] + " Age: " + values[2]
                        + " Grade: " +  values[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
