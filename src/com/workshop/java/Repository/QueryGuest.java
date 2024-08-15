package com.workshop.java.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class QueryGuest extends QueryMaster{
    private  QueryGuest q;
    private final String TIMESTAMP = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
    @Override
    public String SELECTALL(String table){
        return "SELECT * FROM " + table;
    }
    public String GETIDCOMPANY(String table){
        return "SELECT company_id FROM " + table + " WHERE nama = ? ";
    }
    @Override
    public String INSERT(String table){
        return "INSERT INTO " + table + " VALUES (?,?,?,?,?)";
    }
    @Override
    public String DELETE(String table){
        return "DELETE FROM " + table + " WHERE id = ?";
    }
    @Override
    public String SELECTONE(String table,String column){
        return "SELECT " + column + " FROM " + table + " WHERE id = ?";
    }
    @Override
    public String UPDATE(String table,String column){
        return "UPDATE " + table + " set " + column + " = ? WHERE id = ?";
    }
    public String SELETCJOINCOMPANY(String table){
        return "SELECT m.id, m.nama as namaTable, m.harga, c.id as company_id, c.nama as company_name FROM " + table + " m JOIN Company c ON m.company_id = c.id";
    }
    @Override
    public String getTIMESTAMP(){
        return TIMESTAMP;
    }
    private QueryGuest getQ(){
        return q;
    }
}
