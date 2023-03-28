package ru.porochok.diplomproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.porochok.diplomproject.POJO.NameCompany;
import ru.porochok.diplomproject.POJO.Person;
import ru.porochok.diplomproject.POJO.PersonTwoFeild;
import ru.porochok.diplomproject.util.DbUtils;

import java.sql.*;
import java.util.ArrayList;

public class DbPerson extends DbUtils {
    static Connection dbConn = null;

    public void insertPersons(Person person) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO person VALUE (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setString(1, person.getSurname());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getPatronymic());
        preparedStatement.setString(4, person.getPost());
        preparedStatement.setDouble(5, person.getWorkExperience());
        preparedStatement.setLong(6, person.getPassportNumber());
        preparedStatement.setLong(7, person.getInn());
        preparedStatement.setString(8, person.getFamilyComposition());
        preparedStatement.setDate(9, Date.valueOf(person.getDateBorn()));
        preparedStatement.setString(10, person.getPlaceToLive());
        preparedStatement.setString(11, person.getPhoneNumber());

        preparedStatement.executeUpdate();
    }

    public static ObservableList<String> getTargetPerson(String passportNumber) {
        ObservableList<PersonTwoFeild> listPersons = FXCollections.observableArrayList();
        String sql = "SELECT * FROM person WHERE passport_number = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setString(1, passportNumber);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                listPersons.add(new Person(
                        res.getInt("id_person"),
                        res.getString("person_surname"),
                        res.getString("person_name"),
                        res.getString("person_patronymic"),
                        res.getString("person_post"),
                        res.getDouble("work_experience"),
                        res.getLong("passport_number"),
                        res.getLong("inn"),
                        res.getString("family_composition"),
                        res.getDate("date_born").toLocalDate(),
                        res.getString("place_to_live"),
                        res.getString("phone_number")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listPersons.stream().map(
                gg -> {
                    String.valueOf(gg.getId()) + gg.getSurname()
                }
        );
    }

    public void deletePerson(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from person where id_person = ?";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();
    }

    public static ObservableList<Person> searchPersonForPassport(String passport) throws RuntimeException {
        ObservableList<Person> listPersons = FXCollections.observableArrayList();
        String sql = "SELECT * FROM person WHERE passport_number = ?";

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setString(1, passport);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                listPersons.add(new Person(res.getInt("id_person"),
                        res.getString("person_surname"),
                        res.getString("person_name"),
                        res.getString("person_patronymic"),
                        res.getString("person_post"),
                        res.getDouble("work_experience"),
                        res.getLong("passport_number"),
                        res.getLong("inn"),
                        res.getString("family_composition"),
                        res.getDate("date_born").toLocalDate(),
                        res.getString("place_to_live"),
                        res.getString("phone_number")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listPersons;

    }

    public static ObservableList<Person> getPersons() {
        ObservableList<Person> listPersons = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM person");
            //PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM person ORDER B 'id' DESC");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                listPersons.add(new Person(res.getInt("id_person"),
                        res.getString("person_surname"),
                        res.getString("person_name"),
                        res.getString("person_patronymic"),
                        res.getString("person_post"),
                        res.getDouble("work_experience"),
                        res.getLong("passport_number"),
                        res.getLong("inn"),
                        res.getString("family_composition"),
                        res.getDate("date_born").toLocalDate(),
                        res.getString("place_to_live"),
                        res.getString("phone_number")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    public static ObservableList<String> getListFamilyState() {
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM family_composition");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                list.add(res.getString("title_composition"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<String> getListPosts() {
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM post");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                list.add(res.getString("title_post"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
