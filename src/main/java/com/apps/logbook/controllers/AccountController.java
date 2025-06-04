/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apps.logbook.controllers;
import com.apps.logbook.config.DbConnector;
import com.apps.logbook.entities.UserEntity;
import com.apps.logbook.utilities.UserUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author lenovo
 */
public class AccountController {
    private final DbConnector dbConnector;

    public AccountController() {
        this.dbConnector = new DbConnector(); 
    }
        
public boolean registerUser(UserEntity user) throws SQLException {
    String insertQuery = "INSERT INTO users (fname, mname, lname, email, password) VALUES (?, ?, ?, ?, ?)";
    String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

    try (Connection conn = dbConnector.getConnection()) {
        // Check email using the utility method
        if (UserUtilities.emailExists(conn, user.getEmail())) {
            return false;  // Email already exists
        }

        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, user.getFname());
            insertStmt.setString(2, user.getMname());
            insertStmt.setString(3, user.getLname());
            insertStmt.setString(4, user.getEmail());
            insertStmt.setString(5, hashedPassword);
            insertStmt.executeUpdate();
            return true;
        }
    } catch (SQLException e) {
        throw e;
    }
}
    public boolean login(String username, String password){
        //maglalagay dito ng logic para icall ang db, hanapin kung may existing na username at password
        return true;
    }
    
}
