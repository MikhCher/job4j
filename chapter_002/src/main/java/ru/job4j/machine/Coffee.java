package ru.job4j.machine;

public class Coffee {
    public int[] changes(int value, int price) {
        int[] valute = {0, 0, 0, 0, 0, 0};
        int count = 0;
        int difference = value - price;
        int nominal = 100;
        int index = 0;
        while (nominal >= 1) {
            while (difference >= nominal) {
                    difference = difference - nominal;
                    valute[index]++;
                    count++;
            }
            nominal = downgradeNominal(nominal);
            index++;
        }
        nominal = 100;
        int[] result = new int[count];
        int j = 0;
        for (index = 0; index < valute.length; index++) {
            if (valute[index] != 0) {
                for (int i = 0; i < valute[index]; i++, j++) {
                    result[j] = nominal;
                }
            }
            nominal = downgradeNominal(nominal);
        }
        return result;
    }

    private int downgradeNominal(int nominal) {
        if (nominal == 100) {
            nominal = 50;
        } else if (nominal == 50) {
            nominal = 10;
        } else if (nominal == 10) {
            nominal = 5;
        } else if (nominal == 5) {
            nominal = 2;
        } else if (nominal == 2) {
            nominal = 1;
        } else {
            nominal = 0;
        }
        return nominal;
    }
}
