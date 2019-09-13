package ru.job4j.oop;

public class Builder extends Engineer {
    public String organisation;

    public Builder (String name, String surname, String education, int experience, String organisation){
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.experience = experience;
        this.organisation = organisation;
    }

    public String getOrganisation() {
        return this.organisation;
    }

    public void build() {
    }
}
