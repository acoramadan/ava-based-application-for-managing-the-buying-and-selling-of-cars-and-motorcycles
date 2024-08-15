package com.workshop.java.Model;

import com.workshop.java.Repository.QueryMaster;

public class User extends QueryMaster {
    private String userName;
    private String email;
    private String password;
    private final String role = "user";
    public User(String userName, String email, String password){
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
    public User(){}
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
