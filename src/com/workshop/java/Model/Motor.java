package com.workshop.java.Model;

public class Motor {
    private String id;
    private String nama_motor;
    private Double harga;
    private String idCompany;
    private Company company;

    public Motor(String id,String idCompany,String nama_motor, Double harga){
        this.id = id;
        this.idCompany = idCompany;
        this.nama_motor = nama_motor;
        this.harga = harga;
    }
    public Motor(String id,String nama_motor,Double harga){
        this.id = id;
        this.nama_motor = nama_motor;
        this.harga = harga;
    }
    public Motor(String idCompany){
        this.idCompany = idCompany;
    }
    public Motor(){}
    public Double getHarga() {
        return harga;
    }

    public String getNama_motor() {
        return nama_motor;
    }

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getIdCompany() {
        return idCompany;
    }
    public Company getCompany(){
        return company;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    public void setNama_motor(String nama_motor){
        this.nama_motor = nama_motor;
    }
    public void setHarga(Double harga){
        this.harga = harga;
    }
    public void setIdCompany(String idCompany){
        this.idCompany = idCompany;
    }
}
