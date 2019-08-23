package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int i = start; i <= finish; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        int tmp, min, iMin;
        for (int i = 0; i < data.length - 1; i++) {
            min = data[i];
            iMin = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    iMin = j;
                    min = data[j];
                }
            }
            if (iMin != i) {
                tmp = data[i];
                data[i] = data[iMin];
                data[iMin] = tmp;
            }
        }
        return data;
    }
}