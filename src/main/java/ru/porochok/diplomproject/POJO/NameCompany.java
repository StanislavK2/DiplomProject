package ru.porochok.diplomproject.POJO;

public class NameCompany {
    int id;
    String name;

    public NameCompany(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public NameCompany() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
