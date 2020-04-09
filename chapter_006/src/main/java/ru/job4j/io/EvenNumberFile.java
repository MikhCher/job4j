package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder sb = new StringBuilder();
            int symbol;
            int number;
            while ((symbol = in.read()) != -1) {
                if ((char) symbol == '\r') {
                    number = Integer.valueOf(sb.toString());
                    sb.delete(0, sb.length());
                    if (number % 2 == 0) {
                        System.out.println(number);
                    }
                    in.read();
                } else {
                    sb.append((char) symbol);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
