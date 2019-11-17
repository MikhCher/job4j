package ru.job4j.departament;

import java.util.Objects;

public class Division {
    private String division;

    public Division(String division) {
        this.division = division;
    }

    public String getDepartment() {
        return division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Division)) {
            return false;
        }
        Division division1 = (Division) o;
        return Objects.equals(division, division1.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(division);
    }
}