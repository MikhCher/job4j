package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("multiply.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    out.write((j + " * " + i + " = " + i * j + "\t").getBytes());
                }
                out.write("\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
