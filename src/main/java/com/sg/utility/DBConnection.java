package com.sg.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  DBConnection {

    private static Connection connection;

    static {
        try {
            // Change to your database credentials
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}