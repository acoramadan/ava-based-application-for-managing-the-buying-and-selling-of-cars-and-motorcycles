package com.workshop.java.Model;

public class Mobil {
    private String id;
    private String nama_mobil;
    private Double harga;
    private String company_id;
    private Company company;

    public Mobil(String id,String company_id,String nama,Double harga){
        this.id = id;
        this.company_id = company_id;
        this.nama_mobil = nama;
        this.harga = harga;
    }
    public Mobil(String id, String nama_mobil,Double harga){
        this.id = id;
        this.nama_mobil = nama_mobil;
        this.harga = harga;
    }
    public Mobil(String company_id){
        this.company_id = company_id;
    }
    public Mobil(){}
    public String getNama_mobil() {
        return nama_mobil;
    }

    public Double getHarga() {
        return harga;
    }

    public String getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }
    public String getCompany_id(){
        return company_id;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }
}
