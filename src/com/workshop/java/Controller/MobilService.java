package com.workshop.java.Controller;

import com.workshop.java.Repository.QueryGuest;
import com.workshop.java.Model.Company;
import com.workshop.java.Model.Mobil;
import com.workshop.java.Repository.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MobilService extends QueryGuest {

    public Mobil getId(String nama) throws SQLException {
        Mobil mobil = new Mobil();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETIDBYNAMA("mobil"))) {
                pstmt.setString(1, nama);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    mobil.setId(rs.getString("id"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return mobil;
    }

    public void insert(String id, String company_id, String nama, Double harga) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT("mobil"))) {
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
            try (PreparedStatement pstmt = conn.prepareStatement(DELETE("mobil"))) {
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
            try (PreparedStatement pstmt = conn.prepareStatement(UPDATE("mobil", column))) {
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
            try (PreparedStatement pstmt = conn.prepareStatement(UPDATE("mobil", column))) {
                pstmt.setDouble(1, newValue);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public List<Mobil> selectAll() throws SQLException {
        List<Mobil> mobils = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTALL("mobil"))) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Mobil mobil = new Mobil(
                            rs.getString("id"),
                            rs.getString("company_id"),
                            rs.getString("nama"),
                            rs.getDouble("harga")
                    );
                    mobils.add(mobil);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return mobils;
    }

    public List<Mobil> selectAllJoin() throws SQLException {
        List<Mobil> mobils = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELETCJOINCOMPANY("mobil"))) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Company company = new Company(
                            rs.getString("company_id"),
                            rs.getString("company_name")
                    );
                    Mobil mobil = new Mobil(
                            rs.getString("id"),
                            rs.getString("namaTable"),
                            rs.getDouble("harga")
                    );
                    mobil.setCompany(company);
                    mobils.add(mobil);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return mobils;
    }

    public Mobil selectOne(String value, String column) throws SQLException {
        Mobil mobil = new Mobil();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTONE("mobil", column))) {
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    mobil.setId(rs.getString("id"));
                    mobil.setCompany_id(rs.getString("company_id"));
                    mobil.setNama_mobil(rs.getString("nama"));
                    mobil.setHarga(rs.getDouble("harga"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return mobil;
    }

    public Mobil getIdCompany(String nama) throws SQLException {
        Mobil mobil = new Mobil();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETIDCOMPANY("mobil"))) {
                pstmt.setString(1, nama);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    mobil.setCompany_id(rs.getString("company_id"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return mobil;
    }
}
