package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = false, keyMain = data[0][0], keySide = data[0][data.length - 1];
        for (int i = 1; i < data.length; i++){
            int j = data.length - 1 - i;
            if (data[i][i] != keyMain || data[i][j] != keySide){
                return result;
            }
        }
        if (keyMain == keySide || (keyMain != keySide && data.length % 2 == 0)){
            result = true;

        }
        return result;
    }
}