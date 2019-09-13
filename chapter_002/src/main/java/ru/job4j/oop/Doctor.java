package ru.job4j.oop;

public class Doctor extends Profession {
    public boolean male;

    public Doctor() {
    }

    public Doctor (String name, String surname, String education, boolean male){
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.male = male;
    }

    public boolean getMale() {
        return this.male;
    }
    public void heal() {
    }
}
