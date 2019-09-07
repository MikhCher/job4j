package ru.job4j.array;

public class Merger {
    public static int[] merge(int[] first, int[] second) {
        int[] third = new int[20];
        for (int i = 0; i < first.length; i++) {
            int j = i * 2;
            if (first[i] < second[i]) {
                if (j != 0 && third[j - 1] > first[i]) {
                    int tmp = third[j - 1];
                    third[j - 1] = first[i];
                    third[j] = tmp;
                } else {
                    third[j] = first[i];
                }
                third[j + 1] = second[i];
            } else {
                if (j != 0 && third[j - 1] > second[i]) {
                    int tmp = third[j - 1];
                    third[j - 1] = second[i];
                    third[j] = tmp;
                } else {
                    third[j] = second[i];
                }
                third[j + 1] = first[i];
            }
        }
        return third;
    }
}
