package com.workshop.java.Controller;

import com.workshop.java.Repository.QueryTransaksi;
import com.workshop.java.Model.*;
import com.workshop.java.Repository.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaksiService extends QueryTransaksi {

    public List<TransaksiMotor> transaksiMotor(String email, String column) throws SQLException {
        List<TransaksiMotor> transaksiList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETUSERTRANSACTION("transaksi_motor", column))) {
                pstmt.setString(1, email);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    TransaksiMotor motorTransaksi = new TransaksiMotor(
                            rs.getString("id"),
                            rs.getString("pesanan"),
                            rs.getDouble("harga_pesanan"),
                            rs.getString("nama_perusahaan")
                    );
                    transaksiList.add(motorTransaksi);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return transaksiList;
    }

    public List<TransaksiMobil> transaksiMobil(String email, String column) throws SQLException {
        List<TransaksiMobil> transaksiList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETUSERTRANSACTION("transaksi_mobil", column))) {
                pstmt.setString(1, email);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    TransaksiMobil transaksiMobil = new TransaksiMobil(
                            rs.getString("id"),
                            rs.getString("pesanan"),
                            rs.getDouble("harga_pesanan"),
                            rs.getString("nama_perusahaan")
                    );
                    transaksiList.add(transaksiMobil);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return transaksiList;
    }

    public void insert(String id, String pembeliId, String companyId, String MobilId, String table) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT(table, 1))) {
                pstmt.setString(1, id);
                pstmt.setString(2, pembeliId);
                pstmt.setString(3, companyId);
                pstmt.setString(4, MobilId);
                pstmt.setString(5, getTIMESTAMP());
                pstmt.execute();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }
}
