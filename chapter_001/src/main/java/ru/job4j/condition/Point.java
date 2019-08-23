package ru.job4j.condition;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double result = distance(6, 7, 3, 5);
        System.out.println("result (6, 7) to (3, 5) " + result);
        result = distance(3, 1, 9, 2);
        System.out.println("result (3, 1) to (9, 2) " + result);
    }
}
