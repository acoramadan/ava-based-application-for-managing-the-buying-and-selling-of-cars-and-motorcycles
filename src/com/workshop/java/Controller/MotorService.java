package com.workshop.java.Controller;

import com.workshop.java.Repository.QueryGuest;
import com.workshop.java.Model.Company;
import com.workshop.java.Model.Motor;
import com.workshop.java.Repository.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorService extends QueryGuest {

    public Motor getId(String nama) throws SQLException {
        Motor motor = new Motor();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETIDBYNAMA("motor"))) {
                pstmt.setString(1, nama);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    motor.setId(rs.getString("id"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return motor;
    }

    public void insert(String id, String company_id, String nama, Double harga) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT("motor"))) {
                pstmt.setString(1, id);
                pstmt.setString(2, company_id);
                pstmt.setString(3, nama);
                pstmt.setDouble(4, harga);
                pstmt.setString(5, getTIMESTAMP());
                pstmt.execute();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public void delete(String id) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(DELETE("motor"))) {
                pstmt.setString(1, id);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public void update(String newValue, String id, String column) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(UPDATE("motor", column))) {
                pstmt.setString(1, newValue);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public void update(Double newValue, String id, String column) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(UPDATE("motor", column))) {
                pstmt.setDouble(1, newValue);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public List<Motor> selectAll() throws SQLException {
        List<Motor> motors = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTALL("motor"))) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Motor motor = new Motor(
                            rs.getString("id"),
                            rs.getString("company_id"),
                            rs.getString("nama"),
                            rs.getDouble("harga")
                    );
                    motors.add(motor);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return motors;
    }

    public List<Motor> selectAllJoin() throws SQLException {
        List<Motor> motors = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELETCJOINCOMPANY("motor"))) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Company company = new Company(
                            rs.getString("company_id"),
                            rs.getString("company_name")
                    );
                    Motor motor = new Motor(
                            rs.getString("id"),
                            rs.getString("namaTable"),
                            rs.getDouble("harga")
                    );
                    motor.setCompany(company);
                    motors.add(motor);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return motors;
    }

    public Motor selectOne(String value, String column) throws SQLException {
        Motor motor = new Motor();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTONE("motor", column))) {
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    motor.setId(rs.getString("id"));
                    motor.setIdCompany(rs.getString("company_id"));
                    motor.setNama_motor(rs.getString("nama"));
                    motor.setHarga(rs.getDouble("harga"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return motor;
    }

    public Motor getIdCompany(String nama) throws SQLException {
        Motor motor = new Motor();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETIDCOMPANY("motor"))) {
                pstmt.setString(1, nama);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    motor.setIdCompany(rs.getString("company_id"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return motor;
    }
}
