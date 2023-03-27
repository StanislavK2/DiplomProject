package ru.porochok.diplomproject.dismissal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.porochok.diplomproject.POJO.Dismissal;
import ru.porochok.diplomproject.util.DbUtils;

import java.sql.*;

public class DbDismissal extends DbUtils {

    static Connection dbConn = null;

    public void insertDismissal(Dismissal dismissal) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO dismissal VALUE (null, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setDate(1, Date.valueOf(dismissal.getDateCreatedDismissal()));
        preparedStatement.setDate(2, Date.valueOf(dismissal.getDateDoneDismissal()));
        preparedStatement.setInt(3, dismissal.getIdPerson());
        preparedStatement.setString(4, dismissal.getFooting());
        preparedStatement.setDouble(5, dismissal.getSumToPayPerson());

        preparedStatement.executeUpdate();
    }

    public void deletePerson(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM person WHERE id_person = ?";

        PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);

        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    public static ObservableList<Dismissal> searchDismissalForPersonId(int idPerson) throws RuntimeException {
        ObservableList<Dismissal> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM dismissal WHERE id_person = ?";

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setInt(1, idPerson);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new Dismissal(res.getInt("id_dismissal"),
                        res.getDate("date_create_dismissal").toLocalDate(),
                        res.getDate("date_complite_dismissal").toLocalDate(),
                        res.getInt("id_person"),
                        res.getString("footing"),
                        res.getDouble("sum_to_pay")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static ObservableList<Dismissal> searchDismissalForDismissalId(int idDismissal) throws RuntimeException {
        ObservableList<Dismissal> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM dismissal WHERE id_dismissal = ?";

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement(sql);
            preparedStatement.setInt(1, idDismissal);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                list.add(new Dismissal(res.getInt("id_dismissal"),
                        res.getDate("date_create_dismissal").toLocalDate(),
                        res.getDate("date_complite_dismissal").toLocalDate(),
                        res.getInt("id_person"),
                        res.getString("footing"),
                        res.getDouble("sum_to_pay")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static ObservableList<Dismissal> getDismissals() {
        ObservableList<Dismissal> list = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM dismissal");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                list.add(new Dismissal(res.getInt("id_dismissal"),
                        res.getDate("date_create_dismissal").toLocalDate(),
                        res.getDate("date_complite_dismissal").toLocalDate(),
                        res.getInt("id_person"),
                        res.getString("footing"),
                        res.getDouble("sum_to_pay")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Dismissal> getSortedForFooting(String footing) {
        ObservableList<Dismissal> list = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM dismissal WHERE footing = ?");
            preparedStatement.setString(1, footing);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                list.add(new Dismissal(res.getInt("id_dismissal"),
                        res.getDate("date_create_dismissal").toLocalDate(),
                        res.getDate("date_complite_dismissal").toLocalDate(),
                        res.getInt("id_person"),
                        res.getString("footing"),
                        res.getDouble("sum_to_pay")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<String> getListIdPerson() {
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM person");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                list.add(res.getString("id_person"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<String> getListFooting() {
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = getDbConnection(dbConn).prepareStatement("SELECT * FROM footing");
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                list.add(res.getString("title_footing"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
