package com.workshop.java.Controller;

import com.workshop.java.Repository.QueryMaster;
import com.workshop.java.Model.Pembeli;
import com.workshop.java.Repository.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PembeliService extends QueryMaster {

    public void insert(String id, String nama, String email) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT("pembeli", ""))) {
                pstmt.setString(1, id);
                pstmt.setString(2, nama);
                pstmt.setString(3, email);
                pstmt.setString(4, getTIMESTAMP());
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
            try (PreparedStatement pstmt = conn.prepareStatement(DELETE("pembeli"))) {
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
            try (PreparedStatement pstmt = conn.prepareStatement(UPDATE("pembeli", column))) {
                pstmt.setString(1, newValue);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public List<Pembeli> selectAll() throws SQLException {
        List<Pembeli> pembelis = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTALL("pembeli"))) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Pembeli pembeli = new Pembeli(
                            rs.getString("id"),
                            rs.getString("nama"),
                            rs.getString("no_hp")
                    );
                    pembelis.add(pembeli);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return pembelis;
    }

    public Pembeli selectOne(String value, String column) throws SQLException {
        Pembeli pembeli = new Pembeli();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTONE("pembeli", column))) {
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    pembeli.setId(rs.getString("id"));
                    pembeli.setNama(rs.getString("nama"));
                    pembeli.setNo_hp(rs.getString("no_hp"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return pembeli;
    }
}
