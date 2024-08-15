package com.workshop.java.Model;

public class Pembeli {
    private String id;
    private String nama;
    private String no_hp;
    private User user;
    public Pembeli(String id, String nama,String no_hp){
        this.id = id;
        this.nama = nama;
        this.no_hp = no_hp;
    }
    public Pembeli(){}
    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNo_hp(String no_hp){
        this.no_hp = no_hp;
    }
}
