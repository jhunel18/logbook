/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apps.logbook.controllers;

import com.apps.logbook.entities.UserEntity;

/**
 *
 * @author lenovo
 */
public class AccountController {
    
    public boolean registerUser(UserEntity user){
        //Maglalagay pa tayo dito ng logic para icall and database at isave ang user object.
        return true;
    }
    public boolean login(String username, String password){
        //maglalagay dito ng logic para icall ang db, hanapin kung may existing na username at password
        return true;
    }
    
}
