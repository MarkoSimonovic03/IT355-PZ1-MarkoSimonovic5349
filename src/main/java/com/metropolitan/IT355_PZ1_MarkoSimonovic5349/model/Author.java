package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model;

public class Author {
    private String name;
    private String surname;
    private String biography;

    public Author() {
    }

    public Author(String name, String surname, String biography) {
        this.name = name;
        this.surname = surname;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
