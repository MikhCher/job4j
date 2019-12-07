package ru.job4j.lambda.collect;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comparator = ((o1, o2) -> {
            int result = o1.getCity().compareTo(o2.getCity());
            if (result == 0) {
                result = o1.getStreet().compareTo(o2.getStreet());
                if (result == 0) {
                    result = o1.getHome() == o2.getHome()
                            ? Integer.compare(o1.getApartments(), o2.getApartments())
                            : Integer.compare(o1.getHome(), o2.getHome());
                }
            }
            return result;
        });
        return profiles.stream()
                .map(Profile::getAddress)
                .distinct()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
