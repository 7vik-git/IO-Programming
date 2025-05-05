package com.gevernova.filehandling;
import java.io.*;

public class PipedStream {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Thread writer = new Thread(() -> {
            try (OutputStreamWriter osw = new OutputStreamWriter(pos)) {
                osw.write("Hello from writer thread.");
                osw.flush();
            } catch (IOException e) {
                System.out.println("Writer error");
            }
        });

        Thread reader = new Thread(() -> {
            try (InputStreamReader isr = new InputStreamReader(pis)) {
                int ch;
                while ((ch = isr.read()) != -1) {
                    System.out.print((char) ch);
                }
            } catch (IOException e) {
                System.out.println("Reader error");
            }
        });

        writer.start();
        reader.start();
    }
}

