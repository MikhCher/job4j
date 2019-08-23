package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0, month = 0;
        while (amount > 0) {
            if (month == 0) {
                amount += amount * percent * 0.01;
            }
            amount -= monthly;
            month++;
            if (month == 12) {
                year++;
                month = 0;
            }
        }
        year++;
        return year;
    }
}