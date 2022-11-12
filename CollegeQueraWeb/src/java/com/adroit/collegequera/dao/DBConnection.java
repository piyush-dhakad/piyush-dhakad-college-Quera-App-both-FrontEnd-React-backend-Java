package com.adroit.collegequera.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegequera","root","root");
        return cnn;
    }
}
