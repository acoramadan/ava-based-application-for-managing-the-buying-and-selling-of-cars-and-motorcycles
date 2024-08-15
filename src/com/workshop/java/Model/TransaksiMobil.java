package com.workshop.java.Model;

public class TransaksiMobil {
    private String id;
    private String pesanan;
    private Double harga_pesanan;
    private String nama_perusahaan;

    public TransaksiMobil(String id, String pesanan, Double harga_pesanan, String nama_perusahaan){
        this.id = id;
        this.harga_pesanan = harga_pesanan;
        this.nama_perusahaan = nama_perusahaan;
        this.pesanan = pesanan;
    }

    public String getId() {
        return id;
    }

    public Double getHarga_pesanan() {
        return harga_pesanan;
    }

    public String getNama_perusahaan() {
        return nama_perusahaan;
    }

    public String getPesanan() {
        return pesanan;
    }
}
