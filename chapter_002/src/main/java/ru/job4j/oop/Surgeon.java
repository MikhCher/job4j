package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int age;

    public Surgeon (int age){
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void operate() {
    }
}
