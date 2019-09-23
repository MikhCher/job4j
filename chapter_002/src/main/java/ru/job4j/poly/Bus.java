package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengersNumber(int num) {
        System.out.println("В автобусе находится" + num + " человек");
    }

    @Override
    public double refuel(double fuel) {
        double price = 1095.2;
        System.out.println("Вы заправили полный бак, вы должны заплатить" + price + " рублей");
        return price;
    }
}
