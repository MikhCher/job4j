package ru.job4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Connections {
    private List<List<Integer>> rows;

    public Connections(List<List<Integer>> rows) {
        this.rows = rows;
    }

    public List<List<Integer>> sort() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(rows.get(0));
        for (int i = 1; i < rows.size(); i++) {
            Set<Integer> currentSet = new HashSet<>(rows.get(i));
            for (int j = 0; j < rows.size(); j++) {
                if (j == i) {
                    continue;
                }
                Set<Integer> suspectSet = new HashSet<>(rows.get(j));
                suspectSet.retainAll(currentSet);
                if (suspectSet.size() != 0) {
                    result.add(rows.get(i));
                    break;
                }
            }
        }
        return result;
    }
}
