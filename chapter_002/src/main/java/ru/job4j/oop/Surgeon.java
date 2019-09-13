package ru.job4j.oop;

public class Surgeon extends Doctor {
    public int age;

    public Surgeon (String name, String surname, String education, boolean male, int age){
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.male = male;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void operate() {
    }
}
