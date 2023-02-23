package com.bridgelabz;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

import java.io.IOException;

public class  EmployeePayrollService  {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Activate watch Service
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Convert location to file path
        Path path = Paths.get("C:\\Users\\Dell\\Desktop\\IoFiles");

        // Register watch service on above path ==> Pass events to be watched
        // (Create/Delete/Modify)
        path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);


        List<String> logs = new ArrayList<String>();


        boolean poll = true;
        while (poll) {

            // Reference / Pointer current file or folder watching
            WatchKey key = watchService.take();

            // Printing the events (Create / Modify / Delete)
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind : " + event.kind() + " - File : " + event.context());

                logs.add("Event kind : " + event.kind() + " - File : " + event.context());
            }

            Files.write(Paths.get("C:\\Users\\Dell\\Desktop\\IoFiles"), logs, StandardOpenOption.CREATE);

            // Reseting the reference so that it can be used later
            poll = key.reset();
        }

    }

}
