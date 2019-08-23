package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true, key = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] != key) {
                result = false;
                break;
            }
        }
        return result;
    }
}
