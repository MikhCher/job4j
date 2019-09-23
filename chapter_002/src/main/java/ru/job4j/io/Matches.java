package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 11, number;
        boolean player = true;
        while (count != 0) {
            if (player) {
                System.out.println("Первый игрок берет спички. Введите число взятых спичек (максимум 3):");
            } else {
                System.out.println("Второй игрок берет спички. Введите число взятых спичек (максимум 3):");
            }
            number = scanner.nextInt();
            if (number > 3 || number <= 0 || number > count) {
                while (number > 3 || number <= 0 || number > count) {
                    System.out.println("Вы ввели некорректное число. Повторите попытку:");
                    number = scanner.nextInt();
                }
            }
            count -= number;
            System.out.println("Осталось " + count + " спичек.");
            player = !player;
        }
        if (player) {
            System.out.println("Первый игрок побеждает!");
        } else {
            System.out.println("Второй игрок побеждает!");
        }
    }
}
