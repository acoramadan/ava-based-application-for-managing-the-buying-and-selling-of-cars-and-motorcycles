package com.workshop.java.Controller;

import com.workshop.java.Repository.QueryMaster;
import com.workshop.java.Model.Company;
import com.workshop.java.Repository.connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyService extends QueryMaster {

    public Company getId(String nama) throws SQLException {
        Company company = new Company();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(GETIDBYNAMA("Company"))) {
                pstmt.setString(1, nama);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    company.setId(rs.getString("id"));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return company;
    }

    public void insert(String id, String nama) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT("Company"))) {
                pstmt.setString(1, id);
                pstmt.setString(2, nama);
                pstmt.setString(3, getTIMESTAMP());
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
            try (PreparedStatement pstmt = conn.prepareStatement(DELETE("Company"))) {
                pstmt.setString(1, id);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public void update(String newValue, String company_id, String column) throws SQLException {
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(UPDATE("Company", column))) {
                pstmt.setString(1, newValue);
                pstmt.setString(2, company_id);
                pstmt.executeUpdate();
            }
        } finally {
            connection.closeConnection(conn);
        }
    }

    public List<Company> select() throws SQLException {
        List<Company> companies = new ArrayList<>();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTALL("Company"))) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Company company = new Company(
                            rs.getString("id"),
                            rs.getString("nama")
                    );
                    companies.add(company);
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return companies;
    }

    public Company select(String value, String column) throws SQLException {
        Company company = new Company();
        Connection conn = null;
        try {
            conn = connection.getConnection();
            try (PreparedStatement pstmt = conn.prepareStatement(SELECTONE("Company", column))) {
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    company.setNama(rs.getString(column));
                }
            }
        } finally {
            connection.closeConnection(conn);
        }
        return company;
    }
}
