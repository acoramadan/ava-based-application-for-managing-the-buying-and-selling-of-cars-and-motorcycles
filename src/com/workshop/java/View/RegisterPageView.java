package com.workshop.java.View;

import com.workshop.java.Controller.UserService;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterPageView {
    private final UserService userService = new UserService();

    public void register() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Masukkan username : ");
            String userName = scanner.nextLine();

            System.out.print("Masukkan email : ");
            String email = scanner.nextLine();

            System.out.print("Masukkan password : ");
            String password = scanner.nextLine();

            userService.insert(userName,email,password);
            System.out.println("Data berhasil ditambahkan silahkan login");
        }catch (Exception e){
            throw new SQLException("Email tidak bisa digunakan!");
        }
    }
}
