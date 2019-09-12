package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int value) {
        this.load = value;
    }

    public static void main(String[] args) {
        Battery phone = new Battery(36);
        Battery powerbank = new Battery(49);
        System.out.println("phone: " + phone.load + ". powerbank: " + powerbank.load);
        phone.exchange(powerbank);
        System.out.println("phone: " + phone.load + ". powerbank: " + powerbank.load);
    }

    public void exchange(Battery another) {
        this.load += another.load;
        another.load = 0;
    }

}