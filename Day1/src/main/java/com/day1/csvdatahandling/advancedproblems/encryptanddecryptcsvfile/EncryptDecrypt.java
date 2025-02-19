package com.day1.csvdatahandling.advancedproblems.encryptanddecryptcsvfile;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.Base64;

public class EncryptDecrypt {
    private static final String AES = "AES";
    private static SecretKey secretKey;

    // Generate AES Secret Key
    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
            keyGenerator.init(128);
            secretKey = keyGenerator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Error generating AES key!", e);
        }
    }

    // Encrypt Data
    private static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Encryption error", e);
        }
    }

    // Decrypt Data
    private static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
        } catch (Exception e) {
            throw new RuntimeException("Decryption error", e);
        }
    }

    // Encrypt and Write to CSV
    public void encryptAndWriteCSV(String inputFilePath, String encryptedFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(encryptedFilePath))) {

            List<String[]> records = reader.readAll();
            List<String[]> encryptedRecords = new ArrayList<>();

            // Process each row (Encrypt Salary & Email)
            for (int i = 0; i < records.size(); i++) {
                String[] row = records.get(i);
                if (i == 0) { // Header row
                    encryptedRecords.add(row);
                } else {
                    row[3] = encrypt(row[3]); // Encrypt Salary
                    row[4] = encrypt(row[4]); // Encrypt Email
                    encryptedRecords.add(row);
                }
            }

            writer.writeAll(encryptedRecords);
            System.out.println(" Encrypted CSV written successfully: " + encryptedFilePath);

        } catch (IOException | CsvException e) {
            System.err.println(" Error processing CSV: " + e.getMessage());
        }
    }

    // Read Encrypted CSV and Decrypt Data
    public void decryptAndReadCSV(String encryptedFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(encryptedFilePath))) {
            List<String[]> records = reader.readAll();

            // Process and print records
            for (int i = 0; i < records.size(); i++) {
                String[] row = records.get(i);
                if (i != 0) { // Skip header row
                    row[3] = decrypt(row[3]); // Decrypt Salary
                    row[4] = decrypt(row[4]); // Decrypt Email
                }
                System.out.println(Arrays.toString(row));
            }

        } catch (IOException | CsvException e) {
            System.err.println(" Error reading CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EncryptDecrypt csvProcessor = new EncryptDecrypt();

        // File Paths
        String inputCSV = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\encryptanddecryptcsvfile\\input.csv";
        String encryptedCSV = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week5\\Day1\\src\\main\\java\\com\\day1\\csvdatahandling\\advancedproblems\\encryptanddecryptcsvfile\\encryptedcsv.csv";

        // Encrypt and Write to CSV
        csvProcessor.encryptAndWriteCSV(inputCSV, encryptedCSV);

        // Decrypt and Read from CSV
        System.out.println("\nDecrypted Data:");
        csvProcessor.decryptAndReadCSV(encryptedCSV);
    }
}
