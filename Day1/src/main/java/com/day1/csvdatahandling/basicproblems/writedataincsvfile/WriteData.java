package com.day1.csvdatahandling.basicproblems.writedataincsvfile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/day1/csvdatahandling/basicproblems/writedataincsvfile/employee.csv";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){

            //write heading
            bw.write("ID,Name,Department,Salary\n");

            //writing recoreds
            bw.write("101,Manish,Hr,35000\n");
            bw.write("102,Khushagra,Engineer,45000\n");
            bw.write("103,Sachin,Designer,30000\n");
            bw.write("104,Prashant,Tester,51000\n");
            bw.write("105,Mayank,Maintenance,25000\n");
            bw.write("106,Uday,Developer,50000\n");

            System.out.println("CSV File Created and written Successfully");
        }
        catch (IOException e){
            System.out.println("Error Finding File");
            e.printStackTrace();
        }
    }
}
