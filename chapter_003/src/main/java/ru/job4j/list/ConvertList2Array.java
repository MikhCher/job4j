package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int count = 1;
        int rst = list.size() - rows;
        while (rst > 0) {
            rst -= rows;
            count++;
        }
        int cells = count;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (int cellValue : list) {
            array[i][j++] = cellValue;
            if (j % cells == 0) {
                j = 0;
                i++;
        }
        }
        return array;
    }

    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arrayValue : list) {
            for (int listValue : arrayValue) {
                result.add(listValue);
            }
        }
        return result;
    }
}