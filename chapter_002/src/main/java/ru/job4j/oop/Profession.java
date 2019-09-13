package ru.job4j.oop;

public class Profession {
    public String name;
    public String surname;
    public String education;

    public Profession() {
    }

    public Profession (String name, String surname, String education) {
        this.name = name;
        this.surname = surname;
        this.education = education;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEducation() {
        return this.education;
    }
}
