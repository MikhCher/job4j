package ru.job4j.array;

public class Merger {
    public static int[] merge(int[] first, int[] second) {
        int[] third = new int[20];
        for (int i = 0, j = 1; i < first.length; i++) {
            if (first[i] <= second[i] && first[i] >= third[j - 1]) {
                third[i * 2] = first[i];
                third[i * 2 + 1] = second[i];
            } else if (first[i] < second[i] && first[i] <= third[j - 1]) {
                int tmp = third[j - 1];
                third[j - 1] = first[i];
                third[j] = tmp; 
                third[j + 1] = second[i];
            } else if (second[i] < first[i] && second[i] >= third[j - 1]) {
                third[i * 2] = second[i];
                third[i * 2 + 1] = first[i];
            } else {
                int tmp = third[j - 1];
                third[j - 1] = second[i];
                third[j] = tmp;
                third[j + 1] = first[i];
            }
            j += j == 1 ? 1 : 2;
        }
        return third;
    }
}
