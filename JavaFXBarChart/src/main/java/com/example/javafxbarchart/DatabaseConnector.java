package com.example.javafxbarchart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Class for connecting to the database
public class DatabaseConnector {
    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER = "root";
    private static final String PASS = "Sakura";

    // Establishes a connection to the database and returns the Connection object
    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException e) { // If connection fails, throws a runtime exception with an error message
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}