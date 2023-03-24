package ru.porochok.diplomproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.porochok.diplomproject.POJO.Person;
import ru.porochok.diplomproject.POJO.Timesheet;
import ru.porochok.diplomproject.util.DbUtils;

import java.sql.*;

public class DbTimesheet extends DbUtils {
    static Connection dbConn = null;

    public void insertTimesheet(Timesheet timesheet) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO timesheet VALUE (null, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setInt(1, timesheet.getIdPerson());
        preparedStatement.setDate(2, Date.valueOf(timesheet.getStartPeriod()));
        preparedStatement.setDate(3, Date.valueOf(timesheet.getEndPeriod()));
        preparedStatement.setInt(4, timesheet.getNumberDaysForWork());
        preparedStatement.setInt(5, timesheet.getNumberWeekends());
        preparedStatement.setInt(6, timesheet.getNumberVacation());
        preparedStatement.setInt(7, timesheet.getNumberMedical());

        preparedStatement.executeUpdate();
    }

    public static ObservableList<Timesheet> getTimesheet() {
        ObservableList<Timesheet> listPersons = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM timesheet");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                listPersons.add(new Timesheet(
                        res.getInt("id_timesheet"),
                        res.getInt("id_person"),
                        res.getDate("Start_period").toLocalDate(),
                        res.getDate("End_period").toLocalDate(),
                        res.getInt("number_of_days_worked"),
                        res.getInt("number_of_ weekends"),
                        res.getInt("number_vacation"),
                        res.getInt("number_medical")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    public void deleteTimesheet(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from timesheet where id_timesheet = ?";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    public ObservableList<String> getIdPersons() {
        ObservableList<String> listIdPersons = FXCollections.observableArrayList();
        String sql = "SELECT id_person FROM person";

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                listIdPersons.add(res.getString("id_person"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listIdPersons;

    }

    public static ObservableList<Timesheet> searchTimesheetForPersonId(int id) throws RuntimeException {
        ObservableList<Timesheet> listPersons = FXCollections.observableArrayList();
        String sql = "SELECT * FROM timesheet WHERE id_person = ?";

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                listPersons.add(new Timesheet(
                        res.getInt("id_timesheet"),
                        res.getInt("id_person"),
                        res.getDate("Start_period").toLocalDate(),
                        res.getDate("End_period").toLocalDate(),
                        res.getInt("number_of_days_worked"),
                        res.getInt("number_of_ weekends"),
                        res.getInt("number_vacation"),
                        res.getInt("number_medical")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listPersons;
    }
}
