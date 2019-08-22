package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false, key = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] != key){
                break;
            }
            if (i == data.length - 1){
                result = true;
            }
        }
        return result;
    }
}
