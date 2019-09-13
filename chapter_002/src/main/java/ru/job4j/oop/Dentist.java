package ru.job4j.oop;

public class Dentist extends Doctor {
    private int price;

    public Dentist(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void clean() {

    }
}
