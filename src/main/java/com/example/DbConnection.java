package com.example;

import java.sql.*;

public class DbConnection {
    private static final String url = "jdbc:mysql://localhost:3306/gestion_etudiant_auth";
    private static final String user = "root";
    private static final String pass = "";
    private static Connection con;

    public static Connection connection() throws SQLException{
        con = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected Successfuly");
        return con;
    }
}
