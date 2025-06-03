/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apps.logbook.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataInitializer {
    private static DbConnector dbConnector;

    public DataInitializer(DbConnector dbConnector) {
        DataInitializer.dbConnector = dbConnector;
    }
    
    public void createUsersTable() throws SQLException {
        String sql = """
                     CREATE TABLE IF NOT EXISTS users (
                         id SERIAL PRIMARY KEY,
                         fname VARCHAR(50) NOT NULL,
                         mname VARCHAR(50) NOT NULL,
                         lname VARCHAR(50) NOT NULL,
                         email VARCHAR(50) UNIQUE NOT NULL,
                         password VARCHAR(255) NOT NULL
                     )""";
        try (Connection conn = dbConnector.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            throw e;  // Rethrow exception to ensure calling code is aware of the failure
        }
    }
    
    
}
