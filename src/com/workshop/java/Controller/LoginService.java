package com.workshop.java.Controller;

import com.workshop.java.auth.LoginAuthenthication;

import java.sql.SQLException;

public class LoginService {
    private final LoginAuthenthication loginAuthenthication = new LoginAuthenthication();
    public Boolean isLogin(String email,String password){
        try {

            loginAuthenthication.setRoles(email, password);

            if (loginAuthenthication.getRoles().equals("user")
                    || loginAuthenthication.getRoles().equals("admin"))
                return true;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (NullPointerException x){
            throw new NullPointerException("Data tidak ditemukan");
        }
        return false;
    }
}
