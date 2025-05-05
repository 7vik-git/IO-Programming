package com.gevernova.filehandling;
import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        String inputImage = "original.jpg";
        String outputImage = "copy.jpg";

        try (FileInputStream fis = new FileInputStream(inputImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int b;
            while ((b = fis.read()) != -1) {
                baos.write(b);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(outputImage)) {

                int data;
                while ((data = bais.read()) != -1) {
                    fos.write(data);
                }

                System.out.println("Image copied successfully.");
            }
        } catch (IOException e) {
            System.out.println("I/O Error occurred.");
        }
    }
}

