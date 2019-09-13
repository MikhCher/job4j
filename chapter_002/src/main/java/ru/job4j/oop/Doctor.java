package ru.job4j.oop;

public class Doctor extends Profession {
    private boolean male;

    public Doctor() {
    }

    public Doctor (boolean male){
        this.male = male;
    }

    public boolean getMale() {
        return this.male;
    }
    public void heal() {
    }
}
