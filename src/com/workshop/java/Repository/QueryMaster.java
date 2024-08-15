package com.workshop.java.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class QueryMaster {
    private final String TIMESTAMP = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));

    public String GETIDBYNAMA(String table){
        return "SELECT id FROM " + table + " WHERE nama = ? ";
    }

    public String GETEMAILBYUSERNAME(String table){
        return "SELECT email FROM " + table + " WHERE username = ?";
    }
    public String SELECTALL(String table){
        return "SELECT * FROM " + table;
    }

    public String INSERT(String table){
        return "INSERT INTO " + table + " VALUES (?,?,?)";
    }

    public String INSERT(String table,String column){
        return "INSERT INTO " + table + " VALUES (?,?,?,?)";
    }
    public String INSERT(String table, int column){
        return "INSERT INTO " + table + " VALUES (?,?,?,?,?)";
    }
    public String DELETE(String table){
        return "DELETE FROM " + table + " WHERE id = ?";
    }

    public String SELECTONE(String table,String column){
        return "SELECT " + column + " FROM " + table + " WHERE id = ?";
    }

    public String UPDATE(String table, String column){
        return "UPDATE " + table + " set " + column + " = ? WHERE id = ?";
    }
    public String UPDATEBYEMAIL(String table, String column){
        return "UPDATE " + table + " SET " + column + " = ? WHERE email = ?";
    }
    public String GETROLE(){
        return "SELECT role FROM user WHERE email = ? and password = ?";
    }
    public String getTIMESTAMP(){
        return TIMESTAMP;
    }
    public String GETNAMABYEMAILANDPASSWORD(){
        return "SELECT username WHERE email = ? and password = ?";
    }
    public String GETUSERPROFILEDATA(){
        return "SELECT username,email,password FROM user where email = ? and password = ?";
    }
}
