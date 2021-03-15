package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    // This method will read and return data from a CSV file
    public static List<String[]> get(String fileName) {
        List<String[]> data = new ArrayList<String[]>();
        String testRow;
        try {
            // Open and read the file
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // Read data as long as it's not empty
            // Parse the data by "..." using .split() method
            // Place into a temporary Array, then add to List
            while ((testRow = br.readLine()) != null) {
                String[] line = testRow.split(",");
                data.add(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found" + fileName);
        }
        catch (IOException e) {
            System.out.println("Error: Could not read" + fileName);
        }
        return data;
    }
}
