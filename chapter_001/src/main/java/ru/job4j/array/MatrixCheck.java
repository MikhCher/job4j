package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = false, main = data[0][0], side = data[0][data.length - 1];
        for (int i = 1; i < data.length; i++) {
            int j = data.length - 1 - i;
            if (data[i][i] != main || data[i][j] != side) {
                return result;
            }
        }
        if (main == side || (main != side && data.length % 2 == 0)) {
            result = true;

        }
        return result;
    }
}