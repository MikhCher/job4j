package ru.job4j.departament;

import java.util.*;

public class SortDepartment {
    public Set<Division> ascendingSort(Set<Division> divisions) {
        Set<Division> result = new TreeSet<>(new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                String[] codes1 = o1.getDepartment().split("/");
                String[] codes2 = o2.getDepartment().split("/");
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
        fillGaps(divisions);
        result.addAll(divisions);
        return result;
    }

    public Set<Division> descendingSort(Set<Division> divisions) {
        Set<Division> result = new TreeSet<>(new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                String[] codes1 = o1.getDepartment().split("/");
                String[] codes2 = o2.getDepartment().split("/");
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
        fillGaps(divisions);
        result.addAll(divisions);
        return result;
    }

    private void fillGaps(Set<Division> divisions) {
        String[] codes;
        int codeIndex = 0;
        for (Division division : divisions) {
            codes = division.getDepartment().split("/");
            for (String suspect = codes[0]; codeIndex != codes.length - 1; suspect = suspect + "/" + codes[codeIndex]) {
                int index = 0;
                for (Division div : divisions) {
                    if (suspect.equals(div.getDepartment())) {
                        break;
                    }
                    if (index == divisions.size() - 1) {
                        divisions.add(new Division(suspect));
                        fillGaps(divisions);
                        return;
                    }
                    index++;
                }
                codeIndex++;
            }
            codeIndex = 0;
        }
    }
}
