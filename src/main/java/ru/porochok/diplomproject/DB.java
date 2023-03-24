package ru.porochok.diplomproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.porochok.diplomproject.POJO.NameCompany;
import ru.porochok.diplomproject.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class DB extends DbUtils {
    static Connection dbConn = null;

    // Метод для добавления новых заданий внуть таблицы `todo`
    public void insertTask(String task) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO name_company VALUES (null, ?)";

        PreparedStatement prSt = getDbConnection(dbConn).prepareStatement(sql);
        prSt.setString(1, task);

        prSt.executeUpdate();

    }

    // Метод для получения всех заданий из таблицы todo
    public ArrayList<String> getTasks() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM name_company ORDER BY `id` DESC";

        Statement statement = getDbConnection(dbConn).createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> tasks = new ArrayList<>();
        while(res.next())
            tasks.add(res.getInt("id") + " " + res.getString("name"));

        return tasks;
    }

    public static ObservableList<NameCompany> getNameComp() {
        ObservableList<NameCompany> list = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("select * from name_company");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                list.add(new NameCompany(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {

        }
        return list;
    }
}
