package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class EmployeePayrollService {
    public void listFilesDirectory() throws IOException, InterruptedException {
        ArrayList<String> writing = new ArrayList<String>();

        writing.add("Id : 100");
        writing.add("Name : Shiwani Paunikar");
        writing.add("Salary : 800000");
        writing.add("Date : 23-02-2023");
        // File Exist => Override
        // Will create new file if not exist
        Files.write(Paths.get("C:\\Users\\Dell\\Desktop\\IoFiles//shiva.txt"),
                writing, StandardOpenOption.CREATE);
        System.out.println("File added successfully.......");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        EmployeePayrollService obj = new EmployeePayrollService();
        obj.listFilesDirectory();
    }
}