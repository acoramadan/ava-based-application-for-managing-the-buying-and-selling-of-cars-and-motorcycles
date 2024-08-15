package com.workshop.java.View;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {
    private final MenuUser menuUser = new MenuUser();
    private final RegisterPageView registerPageView = new RegisterPageView();

    public void start() {
        int input = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Login");
            System.out.println("2.Register");

            input = scanner.nextInt();
            if (input == 1)
               menuUser.login();

            else if (input == 2)
                registerPageView.register();

            else
                System.out.println("Invalid input!");

        } catch (SQLException e){
            e.getMessage();
        }
    }
}
