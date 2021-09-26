package com.home.questionchallenge.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private DatabaseConnection(){}

    private static final String URL = "jdbc:sqlite:db/challenge_data.db";
    private static Connection connection;

    public  static  Connection getConnection() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }

}
