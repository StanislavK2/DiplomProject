package ru.porochok.diplomproject.POJO;

import java.time.LocalDate;

public class Dismissal {
    private int id;
    private LocalDate dateCreatedDismissal, dateDoneDismissal;
    private int idPerson;
    private String footing;
    private Double sumToPayPerson;

    public Dismissal(int id, LocalDate dateCreatedDismissal, LocalDate dateDoneDismissal, int idPerson, String footing, Double sumToPayPerson) {
        this.id = id;
        this.dateCreatedDismissal = dateCreatedDismissal;
        this.dateDoneDismissal = dateDoneDismissal;
        this.idPerson = idPerson;
        this.footing = footing;
        this.sumToPayPerson = sumToPayPerson;
    }

    @Override
    public String toString() {
        return "\nУнкальный код увольнения - " + this.id + ". \n" +
                "Документ на увольнение составлен - " + this.dateCreatedDismissal + ". \n" +
                "Фактическое увольнение поизошло - " + this.dateDoneDismissal + ". \n" +
                "Код уволенного сотрудника - " + this.idPerson + ". \n" +
                "Уволен по причине - " + this.footing + ". \n" +
                "Выданный остаток - " + this.sumToPayPerson + ".\n\n" +
                "=========================================================================";
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateCreatedDismissal() {
        return dateCreatedDismissal;
    }

    public LocalDate getDateDoneDismissal() {
        return dateDoneDismissal;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public String getFooting() {
        return footing;
    }

    public Double getSumToPayPerson() {
        return sumToPayPerson;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateCreatedDismissal(LocalDate dateCreatedDismissal) {
        this.dateCreatedDismissal = dateCreatedDismissal;
    }

    public void setDateDoneDismissal(LocalDate dateDoneDismissal) {
        this.dateDoneDismissal = dateDoneDismissal;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setFooting(String footing) {
        this.footing = footing;
    }

    public void setSumToPayPerson(Double sumToPayPerson) {
        this.sumToPayPerson = sumToPayPerson;
    }
}
