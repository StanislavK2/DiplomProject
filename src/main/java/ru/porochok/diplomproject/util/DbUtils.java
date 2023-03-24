package ru.porochok.diplomproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB_NAME = "personnel_accounting";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static Connection getDbConnection(Connection dbConn) throws ClassNotFoundException, SQLException {
        String conn = "jdbc:mysql://" + DbUtils.HOST + ":" + DbUtils.PORT + "/" + DbUtils.DB_NAME;

        dbConn = DriverManager.getConnection(conn, DbUtils.LOGIN, DbUtils.PASSWORD);
        return dbConn;
    }
}
