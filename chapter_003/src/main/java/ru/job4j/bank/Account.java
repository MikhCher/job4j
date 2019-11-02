package ru.job4j.bank;

public class Account {
    private double value;
    private String reqs;

    Account(double value, String reqs) {
        this.value = value;
        this.reqs = reqs;
    }

    public void setValue(double value) {
        this.value = value;
    }


    public double getValue() {
        return value;
    }

    public String getReqs() {
        return reqs;
    }
}
