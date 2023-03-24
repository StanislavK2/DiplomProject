package ru.porochok.diplomproject.POJO;

import java.time.LocalDate;

public class Timesheet {
    private int id;
    private int idPerson;
    private LocalDate startPeriod, endPeriod;
    private int numberDaysForWork, numberWeekends, numberVacation, numberMedical;

    public Timesheet(int id, int idPerson, LocalDate startPeriod, LocalDate endPeriod, int numberDaysForWork, int numberWeekends, int numberVacation, int numberMedical) {
        this.id = id;
        this.idPerson = idPerson;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.numberDaysForWork = numberDaysForWork;
        this.numberWeekends = numberWeekends;
        this.numberVacation = numberVacation;
        this.numberMedical = numberMedical;
    }

    public int getId() {
        return id;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public LocalDate getStartPeriod() {
        return startPeriod;
    }

    public LocalDate getEndPeriod() {
        return endPeriod;
    }

    public int getNumberDaysForWork() {
        return numberDaysForWork;
    }

    public int getNumberWeekends() {
        return numberWeekends;
    }

    public int getNumberVacation() {
        return numberVacation;
    }

    public int getNumberMedical() {
        return numberMedical;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setStartPeriod(LocalDate startPeriod) {
        this.startPeriod = startPeriod;
    }

    public void setEndPeriod(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

    public void setNumberDaysForWork(int numberDaysForWork) {
        this.numberDaysForWork = numberDaysForWork;
    }

    public void setNumberWeekends(int numberWeekends) {
        this.numberWeekends = numberWeekends;
    }

    public void setNumberVacation(int numberVacation) {
        this.numberVacation = numberVacation;
    }

    public void setNumberMedical(int numberMedical) {
        this.numberMedical = numberMedical;
    }
}
