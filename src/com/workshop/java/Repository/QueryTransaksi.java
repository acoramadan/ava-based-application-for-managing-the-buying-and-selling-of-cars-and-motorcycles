package com.workshop.java.Repository;

public class QueryTransaksi extends QueryMaster{

    public String GETUSERTRANSACTION(String table,String column){

        String columnId = column + "_id";
        return "SELECT t.id, m.nama AS pesanan, m.harga AS harga_pesanan, c.nama AS nama_perusahaan " +
                "FROM " + table + " t INNER JOIN "+ column + " m ON t."+ columnId + " = m.id INNER JOIN Company c " +
                "ON t.company_id = c.id INNER JOIN pembeli b ON t.pembeli_id = b.id WHERE b.email = ?";

    }
}
