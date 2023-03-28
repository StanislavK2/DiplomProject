package ru.porochok.diplomproject.contract;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.porochok.diplomproject.POJO.Department;
import ru.porochok.diplomproject.POJO.EmploymentContract;
import ru.porochok.diplomproject.POJO.Person;
import ru.porochok.diplomproject.POJO.PersonTwoFeild;
import ru.porochok.diplomproject.department.DeportmentLayoutController;
import ru.porochok.diplomproject.util.DbUtils;

import java.sql.*;

public class DbEmploymentContract extends DbUtils {

    static Connection dbConn = null;

    public void insertContract(EmploymentContract contract) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employment_contract VALUE (null, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setString(1, contract.getNameDeportment());
        preparedStatement.setDate(2, Date.valueOf(contract.getDateCreateContract()));
        preparedStatement.setDate(3, Date.valueOf(contract.getDateDoneContract()));
        preparedStatement.setString(4, contract.getIdAndNamePerson());
        preparedStatement.setInt(5, contract.getSalary());
        preparedStatement.setInt(6, contract.getTestPeriod());
        preparedStatement.setString(7, contract.getTermOfTheContract());
        preparedStatement.setString(8, contract.getPlaceToWork());
        preparedStatement.setString(9, contract.getModeToWork());

        preparedStatement.executeUpdate();
    }

    public static ObservableList<EmploymentContract> getTargetContractForNameDeportment(String nameDeportment) {
        ObservableList<EmploymentContract> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employment_contract WHERE name_deportment = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setString(1, nameDeportment);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new EmploymentContract(
                        res.getInt("id_contract"),
                        res.getString("name_deportment"),
                        res.getDate("date_create_contract").toLocalDate(),
                        res.getDate("date_done_contract").toLocalDate(),
                        res.getString("id_and_name_person"),
                        res.getInt("salary"),
                        res.getInt("test_period"),
                        res.getString("term_of_the_contract"),
                        res.getString("place_to_live"),
                        res.getString("mode_to_work")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<EmploymentContract> getTargetContractForNamePerson(String nameAndIdPerson) {
        ObservableList<EmploymentContract> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employment_contract WHERE id_and_name_person = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setString(1, nameAndIdPerson);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new EmploymentContract(
                        res.getInt("id_contract"),
                        res.getString("name_deportment"),
                        res.getDate("date_create_contract").toLocalDate(),
                        res.getDate("date_done_contract").toLocalDate(),
                        res.getString("id_and_name_person"),
                        res.getInt("salary"),
                        res.getInt("test_period"),
                        res.getString("term_of_the_contract"),
                        res.getString("place_to_live"),
                        res.getString("mode_to_work")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ObservableList<EmploymentContract> getAllContracts() {
        ObservableList<EmploymentContract> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employment_contract";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new EmploymentContract(
                        res.getInt("id_contract"),
                        res.getString("name_deportment"),
                        res.getDate("date_create_contract").toLocalDate(),
                        res.getDate("date_done_contract").toLocalDate(),
                        res.getString("id_and_name_person"),
                        res.getInt("salary"),
                        res.getInt("test_period"),
                        res.getString("term_of_the_contract"),
                        res.getString("place_to_live"),
                        res.getString("mode_to_work")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<EmploymentContract> sortContractForTermOfContract(String termOfTheContract) {
        ObservableList<EmploymentContract> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employment_contract WHERE term_of_the_contract = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setString(1, termOfTheContract);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new EmploymentContract(
                        res.getInt("id_contract"),
                        res.getString("name_deportment"),
                        res.getDate("date_create_contract").toLocalDate(),
                        res.getDate("date_done_contract").toLocalDate(),
                        res.getString("id_and_name_person"),
                        res.getInt("salary"),
                        res.getInt("test_period"),
                        res.getString("term_of_the_contract"),
                        res.getString("place_to_live"),
                        res.getString("mode_to_work")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Department> getNameDeportment() {
        ObservableList<Department> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM deportment";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new Department(res.getString("title")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<PersonTwoFeild> getPerson() {
        ObservableList<PersonTwoFeild> listPersons = FXCollections.observableArrayList();
        String sql = "SELECT id_person, person_surname FROM person";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                listPersons.add(new PersonTwoFeild(
                        res.getInt("id_person"),
                        res.getString("person_surname")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    public static ObservableList<EmploymentContract> sortContractForPlaceToWork(String placeToWork) {
        ObservableList<EmploymentContract> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employment_contract WHERE term_of_the_contract = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setString(1, placeToWork);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new EmploymentContract(
                        res.getInt("id_contract"),
                        res.getString("name_deportment"),
                        res.getDate("date_create_contract").toLocalDate(),
                        res.getDate("date_done_contract").toLocalDate(),
                        res.getString("id_and_name_person"),
                        res.getInt("salary"),
                        res.getInt("test_period"),
                        res.getString("term_of_the_contract"),
                        res.getString("place_to_live"),
                        res.getString("mode_to_work")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
