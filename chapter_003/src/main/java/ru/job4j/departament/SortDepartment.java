package ru.job4j.departament;

import java.util.*;

public class SortDepartment {
    public Set<Division> ascendingSort(Set<Division> divisions) {
        Set<Division> result = new TreeSet<>(new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                String[] codes1 = getCodes(o1);
                String[] codes2 = getCodes(o2);
                int result = 0;
                int min = Math.min(codes1.length, codes2.length);
                for (int codeIndex = 0; codeIndex < min; codeIndex++) {
                    int compareResult = codes1[codeIndex].compareTo(codes2[codeIndex]);
                    if (compareResult != 0) {
                        result = compareResult;
                        break;
                    }
                    if (codeIndex == min - 1) {
                        result = codes1.length == codeIndex + 1 ? -1 : 1;
                    }
                }
                return result;
            }
        });
        result.addAll(divisions);
        return result;
    }

    public Set<Division> descendingSort(Set<Division> divisions) {
        Set<Division> result = new TreeSet<>(new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                String[] codes1 = getCodes(o1);
                String[] codes2 = getCodes(o2);
                int result = 0;
                int min = Math.min(codes1.length, codes2.length);
                for (int codeIndex = 0; codeIndex < min; codeIndex++) {
                    int compareResult = codes1[codeIndex].compareTo(codes2[codeIndex]);
                    if (compareResult != 0) {
                        result = compareResult * -1;
                        break;
                    }
                    if (codeIndex == min - 1) {
                        result = codes1.length == codeIndex + 1 ? -1 : 1;
                    }
                }
                return result;
            }
        });
        result.addAll(divisions);
        return result;
    }

    private String[] getCodes(Division division) {
        return division.getDepartment().split("/");
    }
}
