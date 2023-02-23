package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EmployeePayrollService {
    public long listFilesDirectory() throws IOException, InterruptedException {

        long enteries = 0;
        enteries = Files.lines(new File("C:\\Users\\Dell\\Desktop\\IoFiles\\shiva.txt")
                .toPath()).count();
        System.out.println(enteries+"=count");
        return enteries;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        EmployeePayrollService emp = new EmployeePayrollService();
        emp.listFilesDirectory();

    }
}
