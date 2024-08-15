package com.workshop.java.auth;

import com.workshop.java.Repository.QueryMaster;
import com.workshop.java.Repository.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuthenthication extends QueryMaster {
    private String roles;

    public void setRoles(String email, String password) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETROLE())) {
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    this.roles = rs.getString("role");
                } else {
                    throw new NullPointerException("Data tidak ditemukan!");
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public String getRoles() {
        return roles;
    }
}
