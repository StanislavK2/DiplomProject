package ru.porochok.diplomproject.POJO;

import java.time.LocalDate;

public class EmploymentContract {
    private int idContract;
    private String nameDeportment;
    private LocalDate dateCreateContract, dateDoneContract;
    private String idAndNamePerson;
    private int salary, testPeriod;
    private String termOfTheContract, placeToWork, modeToWork;

    public EmploymentContract(int idContract, String nameDeportment, LocalDate dateCreateContract, LocalDate dateDoneContract, String idAndNamePerson, int salary, int testPeriod, String termOfTheContract, String placeToWork, String modeToWork) {
        this.idContract = idContract;
        this.nameDeportment = nameDeportment;
        this.dateCreateContract = dateCreateContract;
        this.dateDoneContract = dateDoneContract;
        this.idAndNamePerson = idAndNamePerson;
        this.salary = salary;
        this.testPeriod = testPeriod;
        this.termOfTheContract = termOfTheContract;
        this.placeToWork = placeToWork;
        this.modeToWork = modeToWork;
    }

    public int getIdContract() {
        return idContract;
    }

    public String getNameDeportment() {
        return nameDeportment;
    }

    public LocalDate getDateCreateContract() {
        return dateCreateContract;
    }

    public LocalDate getDateDoneContract() {
        return dateDoneContract;
    }

    public String getIdAndNamePerson() {
        return idAndNamePerson;
    }

    public int getSalary() {
        return salary;
    }

    public int getTestPeriod() {
        return testPeriod;
    }

    public String getTermOfTheContract() {
        return termOfTheContract;
    }

    public String getPlaceToWork() {
        return placeToWork;
    }

    public String getModeToWork() {
        return modeToWork;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public void setNameDeportment(String nameDeportment) {
        this.nameDeportment = nameDeportment;
    }

    public void setDateCreateContract(LocalDate dateCreateContract) {
        this.dateCreateContract = dateCreateContract;
    }

    public void setDateDoneContract(LocalDate dateDoneContract) {
        this.dateDoneContract = dateDoneContract;
    }

    public void setIdAndNamePerson(String idAndNamePerson) {
        this.idAndNamePerson = idAndNamePerson;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTestPeriod(int testPeriod) {
        this.testPeriod = testPeriod;
    }

    public void setTermOfTheContract(String termOfTheContract) {
        this.termOfTheContract = termOfTheContract;
    }

    public void setPlaceToWork(String placeToWork) {
        this.placeToWork = placeToWork;
    }

    public void setModeToWork(String modeToWork) {
        this.modeToWork = modeToWork;
    }
}
