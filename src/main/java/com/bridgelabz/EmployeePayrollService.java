package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
public class EmployeePayrollService {
    public void empPayrollRead() throws IOException {
        Path lines = Paths.get("C:\\Users\\Dell\\Desktop\\IoFiles");
            Files.list(lines).filter(Files::isRegularFile).forEach(System.out::print);
            Files.newDirectoryStream(lines).forEach(System.out::println);
            Files.newDirectoryStream(lines, path -> path.toFile().isFile() && path.toString().startsWith("temp"));

    }

    public static void main(String[] args) throws IOException {
        EmployeePayrollService emp = new EmployeePayrollService();
        emp.empPayrollRead();
    }
}
