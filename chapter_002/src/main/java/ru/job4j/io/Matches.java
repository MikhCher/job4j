package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 11, number;
        boolean first = true;
        String player;
        while (count != 0) {
            if (first) {
                player = "Первый";
                first = false;
            } else {
                player = "Второй";
                first = true;
            }
            System.out.println(player + " игрок берет спички. Введите число взятых спичек (максимум 3):");
            number = scanner.nextInt();
            if (number > 3 || number <= 0 || number > count) {
                while (number > 3 || number <= 0 || number > count) {
                    System.out.println("Вы ввели некорректное число. Повторите попытку:");
                    number = scanner.nextInt();
                }
            }
            count -= number;
            System.out.println("Осталось " + count + " спичек.");
        }
    }
}
