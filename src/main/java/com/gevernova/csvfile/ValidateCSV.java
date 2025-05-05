package com.gevernova.csvfile;
import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("users.csv"));
        String line = br.readLine();
        System.out.println(line);
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String email = data[2];
            String phone = data[3];
            boolean emailValid = emailPattern.matcher(email).matches();
            boolean phoneValid = phonePattern.matcher(phone).matches();
            if (!emailValid || !phoneValid) {
                System.out.println("Invalid: " + line);
                if (!emailValid) System.out.println(" → Invalid email");
                if (!phoneValid) System.out.println(" → Invalid phone");
            }
        }
        br.close();
    }
}

