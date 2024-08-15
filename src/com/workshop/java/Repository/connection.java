package com.workshop.java.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

    private connection() {
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/Tugas_Workshoop", "root", "");
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println( e.getMessage());
            }
        }
    }
}
