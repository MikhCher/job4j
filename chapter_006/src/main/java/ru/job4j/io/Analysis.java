package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (
                BufferedReader read = new BufferedReader(new FileReader(source));
                PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            String start = "";
            String line = read.readLine();
            while (line != null) {
                String[] data = line.split(" ");
                if (Integer.valueOf(data[0]) >= 400) {
                    if (start.isEmpty()) {
                        start = data[1];
                    }
                } else if (!start.isEmpty()) {
                    String outLine = start + ";" + data[1];
                    out.println(outLine);
                    start = "";
                }
                line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}