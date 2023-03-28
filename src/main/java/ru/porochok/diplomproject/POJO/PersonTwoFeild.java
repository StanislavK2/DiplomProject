package ru.porochok.diplomproject.POJO;

public class PersonTwoFeild {
    private int id;
    private String surname;

    public PersonTwoFeild(int id, String surname) {
        this.id = id;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return this.id + " " + this.surname;
    }
}
