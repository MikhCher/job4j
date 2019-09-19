package ru.job4j.oop;

public class Engineer extends Profession {
    private int experience;

    public Engineer() {
    }

    public Engineer(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    public void create(String creation) {
    }
}
