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
import java.sql.ResultSet;
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
        
public boolean registerUser(UserEntity usr) throws SQLException {
    String insertQuery = "INSERT INTO users (fname, mname, lname, email, password) VALUES (?, ?, ?, ?, ?)";
    String hashedPassword = BCrypt.hashpw(usr.getPassword(), BCrypt.gensalt());

    try (Connection conn = dbConnector.getConnection()) {
        // Check email using the utility method
        if (UserUtilities.emailExists(conn, usr.getEmail())) {
            return false;  // Email already exists
        }

        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, usr.getFname());
            insertStmt.setString(2, usr.getMname());
            insertStmt.setString(3, usr.getLname());
            insertStmt.setString(4, usr.getEmail());
            insertStmt.setString(5, hashedPassword);
            insertStmt.executeUpdate();
            return true;
        }
    } catch (SQLException e) {
        throw e;
    }
}
    public boolean login(UserEntity user) throws SQLException{
        String loginQuery = "SELECT password FROM users WHERE email = ?";
        
        try(Connection conn = dbConnector.getConnection(); ){
           try(PreparedStatement loginStatement = conn.prepareStatement(loginQuery)){
               loginStatement.setString(1, user.getEmail());
               try(ResultSet rs = loginStatement.executeQuery()){
                   if(rs.next()){
                       String storedHashedPassword = rs.getString("password");
                       return BCrypt.checkpw(user.getPassword(), storedHashedPassword); // Password matches
                   }
                   return false; // return false if the email is not found
               }
           }
        }
        catch(SQLException e){
            throw e;
        }
    }    
}
