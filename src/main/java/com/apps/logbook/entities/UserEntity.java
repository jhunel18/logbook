/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apps.logbook.entities;

/**
 *
 * @author lenovo
 */
public class UserEntity {
    private String fname;
    private String mname;
    private String lname;
    private String email;
    private String password;
    
    public UserEntity(String fname, String mname, String lname, String email, String password) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }
    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public boolean hasBlankFields() {
        return fname.isBlank() || lname.isBlank() || email.isBlank() || password.isBlank();
    }
    
}
