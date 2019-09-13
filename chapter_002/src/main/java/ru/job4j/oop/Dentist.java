package ru.job4j.oop;

public class Dentist extends Doctor {
    public int price;

    public Dentist(String name, String surname, String education, boolean male, int price) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.male = male;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void clean() {

    }
}
