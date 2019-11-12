package ru.job4j.lambda.collect;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartments;

    public Address(String city, String street, int home, int apartments) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartments = apartments;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartments() {
        return apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return getHome() == address.getHome()
                && getApartments() == address.getApartments()
                && getCity().equals(address.getCity())
                && getStreet().equals(address.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getHome(), getApartments());
    }
}
