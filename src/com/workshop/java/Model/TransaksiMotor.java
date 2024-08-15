package com.workshop.java.Model;

public class TransaksiMotor {
    private String id;
    private String pesanan;
    private Double hargaPesanan;
    private String namaPerusahaan;

    public TransaksiMotor(String id,String pesanan,Double hargaPesanan,String namaPerusahaan){
        this.id = id;
        this.pesanan = pesanan;
        this.hargaPesanan = hargaPesanan;
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getPesanan() {
        return pesanan;
    }

    public Double getHargaPesanan() {
        return hargaPesanan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public String getId() {
        return id;
    }

}
