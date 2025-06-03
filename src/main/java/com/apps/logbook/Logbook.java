/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.apps.logbook;
import com.apps.logbook.forms.LoginForm;
import com.apps.logbook.config.DataInitializer;
import com.apps.logbook.config.DbConnector;
import java.sql.SQLException;
/**
 *
 * @author lenovo
 */
public class Logbook {

    public static void main(String[] args) throws SQLException {
        //Initializer the dbConnector and the database for logbook
        DbConnector dbConnector = new DbConnector();
        dbConnector.createDatabaseIfNotExists();
        
        //Initialize a table in the database
        DataInitializer dataInitializer = new DataInitializer(dbConnector);
        dataInitializer.createUsersTable();
        
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
