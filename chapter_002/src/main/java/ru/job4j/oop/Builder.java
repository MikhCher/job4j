package ru.job4j.oop;

public class Builder extends Engineer {
    private String organisation;

    public Builder (String organisation){
        this.organisation = organisation;
    }

    public String getOrganisation() {
        return this.organisation;
    }

    public void build() {
    }
}
