package com.workshop.java.Model;

public class Company {

    private String id;
    private String nama;
    public Company(String id, String nama){
        this.id = id;
        this.nama = nama;
    }
    public Company(){}
    public String getNama(){
        return nama;
    }
    public String getId(){
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(String id) {
        this.id = id;
    }
}
