package ru.job4j.oop;

public class Engineer extends Profession {
    public int experience;

    public Engineer() {
    }

    public Engineer (String name, String surname, String education, int experience) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    public void create(String creation) {
    }
}
