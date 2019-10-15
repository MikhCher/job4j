package ru.job4j.machine;

public class Coffee {
    private int[] change = new int[100];

    public int[] changes(int value, int price) {
        int index = 0;
        int difference = value - price;
        int nominal = 100;
        while (nominal != 0) {
            while (difference - nominal >= 0) {
                this.change[index++] = nominal;
                difference -= nominal;
            }
            nominal = downgradeNominal(nominal);
        }
        int[] result = new int[index];
        System.arraycopy(this.change, 0, result, 0, index);
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
