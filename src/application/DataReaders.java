package application;

import java.util.List;

public class DataReaders {

    public static void main(String[] args) {
        readXLS();
    }

    public static void readCSV() {
        String fileName = "C:\\temp\\newAccounts.txt";
        List<String[]> records = utilities.CSV.get(fileName);

        // Iterating trough the list
        for (String[] record : records) {
            for (String field : record) {
                System.out.println(field);
            }
        }
    }

    public static void readXLS() {
        String fileName = "C:\\temp\\UserLogin.xls";
        String[][] data = utilities.Excel.get(fileName);
        for (String[] record : data) {
            System.out.println("\nNEW RECORD:");
            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
        }
    }
}
