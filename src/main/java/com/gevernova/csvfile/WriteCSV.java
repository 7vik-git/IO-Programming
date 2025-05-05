package com.gevernova.csvfile;
import java.io.*;

public class WriteCSV {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"));
        bw.write("ID,Name,Department,Salary\n");
        bw.write("1,Alice,HR,50000\n");
        bw.write("2,Bob,IT,60000\n");
        bw.write("3,Charlie,Finance,55000\n");
        bw.write("4,David,Marketing,52000\n");
        bw.write("5,Eve,IT,61000\n");
        bw.close();
    }
}

