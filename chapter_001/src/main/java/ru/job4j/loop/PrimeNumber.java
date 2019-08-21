package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0, k = 0;
        for (int i = 1; i <= finish; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && j != 1 && j != i) {
                    k++;
                    break;
                }
            }
            if (k == 0 && i != 1) {
                count++;
            }
            else k = 0;
        }
        return count;
    }
}
