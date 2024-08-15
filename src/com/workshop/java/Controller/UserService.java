package com.workshop.java.Controller;

import com.workshop.java.Repository.QueryMaster;
import com.workshop.java.Model.User;
import com.workshop.java.Repository.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService extends QueryMaster {

    public void insert(String userName, String email, String password) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT("user", 0))) {
                pstmt.setString(1, userName);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.setString(4, "user");
                pstmt.setString(5, getTIMESTAMP());
                pstmt.execute();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public void update(String newValue, String email, String column) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(UPDATEBYEMAIL("user", column))) {
                pstmt.setString(1, newValue);
                pstmt.setString(2, email);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public void delete(String email) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(DELETE("user"))) {
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public User showUserProfile(String email, String password) throws SQLException {
        User user = new User();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETUSERPROFILEDATA())) {
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    user = new User(
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return user;
    }

    public User showNama(String email, String password) throws SQLException {
        User user = new User();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETNAMABYEMAILANDPASSWORD())) {
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    user.setUserName(rs.getString("username"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return user;
    }
}
