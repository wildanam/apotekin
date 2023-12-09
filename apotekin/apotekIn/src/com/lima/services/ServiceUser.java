/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lima.services;

import com.lima.models.ModelLogin;
import com.lima.models.ModelUser;
import com.lima.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Wildan
 */
public class ServiceUser {
    private final Connection con;
    
    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        PreparedStatement p = con.prepareStatement("select * from `users` where BINARY(username)=? and BINARY(`Password`)=? limit 1");
        p.setString(1, login.getUserName());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if (r.first()) {
            String userName = r.getString(1);
            String password = r.getString(2);
            data = new ModelUser(userName, password);
        }
        r.close();
        p.close();
        return data;
    }
}
