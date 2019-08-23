package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array){
        int duplicates = 0;
        String tmp;
        for (int i = 0; i < array.length - duplicates; i++){
            for (int j = i + 1; j < array.length - duplicates; j++){
                if (array[i].equals(array[j])){
                    tmp = array[j];
                    array[j] = array[array.length - 1 - duplicates];
                    array[array.length - 1 - duplicates] = tmp;
                    duplicates++;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - duplicates);
    }
}
