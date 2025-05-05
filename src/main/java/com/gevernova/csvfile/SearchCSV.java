package com.gevernova.csvfile;
import java.io.*;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String name = sc.nextLine().trim();

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String line = br.readLine();
        boolean found = false;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(name)) {
                System.out.println("Department: " + data[2] + ", Salary: " + data[3]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Employee not found");
        br.close();
    }
}

