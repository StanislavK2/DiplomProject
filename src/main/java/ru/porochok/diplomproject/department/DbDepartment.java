package ru.porochok.diplomproject.department;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.porochok.diplomproject.POJO.Department;
import ru.porochok.diplomproject.POJO.Dismissal;
import ru.porochok.diplomproject.util.DbUtils;

import java.sql.*;

public class DbDepartment extends DbUtils {

    static Connection dbConn = null;

    public static ObservableList<Department> getDepartment() {
        ObservableList<Department> list = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM deportment");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                list.add(new Department(res.getString("title")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deletePerson(String title) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM deportment WHERE title = ?";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setString(1, title);

        preparedStatement.executeUpdate();
    }

    public void insertDepartment(Department department) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO deportment VALUE (?)";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setString(1, department.getTitle());

        preparedStatement.executeUpdate();
    }
}
