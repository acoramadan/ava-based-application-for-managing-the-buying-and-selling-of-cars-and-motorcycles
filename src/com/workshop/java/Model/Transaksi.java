package com.workshop.java.Model;

public class Transaksi<T> {
    private T t;
    private String id;
    private String pesanan;
    private Double hargaPesanan;
    private String namaPerusahaan;

    public Transaksi(String id,String pesanan,Double hargaPesanan, String namaPerusahaan, T t){
        this.id = id;
        this.pesanan = pesanan;
        this.hargaPesanan = hargaPesanan;
        this.namaPerusahaan = namaPerusahaan;
        this.t = t;
    }
    public Transaksi(){}
    public T getData(){
        return t;
    }
    public void setData(T t){
        this.t = t;
    }
}
