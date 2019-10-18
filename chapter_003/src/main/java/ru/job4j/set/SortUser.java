package ru.job4j.set;

import java.util.*;

public class SortUser {
    public Set<User> sort (List<User> list) {
        Set<User> set = new TreeSet<>();
        set.addAll(list);
        return set;
    }

    public List<User> sortNameLength (List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return list;
    }

    public List<User> sortByAllFields (List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int nameResult = Integer.compare(o1.getName().length(), o2.getName().length());
                        int ageResult = Integer.compare(o1.getAge(), o2.getAge());
                        int result;
                        if (nameResult != 0 && ageResult != 0) {
                            result = nameResult < 0 ? -1 : 1;
                        } else if (nameResult != 0 && ageResult == 0) {
                            result = nameResult < 0 ? -1 : 1;
                        } else if (nameResult == 0 && ageResult != 0) {
                            result = ageResult < 0 ? -1 : 1;
                        } else {
                            result = 0;
                        }
                        return result;
                    }
                }
        );
        return list;
    }
}
