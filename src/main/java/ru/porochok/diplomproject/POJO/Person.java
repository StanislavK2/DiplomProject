package ru.porochok.diplomproject.POJO;

import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.time.LocalDate;

public class Person {

    private int id;
    private String surname, name, patronymic, post;
    private double workExperience;
    private Long passportNumber, inn;
    private String familyComposition;
    private LocalDate dateBorn;
    private String placeToLive, phoneNumber;

    public Person(int id,
                  String surname,
                  String name,
                  String patronymic,
                  String post,
                  double workExperience,
                  Long passportNumber,
                  Long inn,
                  String familyComposition,
                  LocalDate dateBorn,
                  String placeToLive,
                  String phoneNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.post = post;
        this.workExperience = workExperience;
        this.passportNumber = passportNumber;
        this.inn = inn;
        this.familyComposition = familyComposition;
        this.dateBorn = dateBorn;
        this.placeToLive = placeToLive;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPost() {
        return post;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public Long getInn() {
        return inn;
    }

    public String getFamilyComposition() {
        return familyComposition;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public String getPlaceToLive() {
        return placeToLive;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }

    public void setPassportNumber(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public void setFamilyComposition(String familyComposition) {
        this.familyComposition = familyComposition;
    }

    public void setDateBorn(LocalDate dateBorn) {
        this.dateBorn = dateBorn;
    }

    public void setPlaceToLive(String placeToLive) {
        this.placeToLive = placeToLive;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\n| " + this.id + " " + this.surname + " " + this.name + " " + this.patronymic + "\n" +
        "Должность - " + this.post + ". Стаж работы - [" + this.workExperience + "]. \n" +
        "Номе паспорта - [" + this.passportNumber + "]. ИНН - [" + this.inn + "]\n" +
        "Семейное положение - " + this.familyComposition + ". Дата рождения - [" + this.dateBorn + "]. \n" +
        "Место проживания - " + this.placeToLive + ".\nНомер телефона - [" + this.phoneNumber + "] " + " |\n\n" +
                "=========================================================================";
    }
}
