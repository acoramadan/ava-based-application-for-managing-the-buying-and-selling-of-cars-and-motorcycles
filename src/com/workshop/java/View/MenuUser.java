package com.workshop.java.View;

import com.workshop.java.Controller.*;
import com.workshop.java.Model.*;
import com.workshop.java.auth.LoginAuthenthication;

import java.util.Random;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuUser {

    private final LoginService loginService = new LoginService();
    private final UserService userService = new UserService();
    private final MobilService mobilService = new MobilService();
    private final MotorService motorService = new MotorService();
    private final PembeliService pembeliService = new PembeliService();
    private final TransaksiService transaksiService = new TransaksiService();
    private final LoginAuthenthication loginAuthenthication = new LoginAuthenthication();
    private final MenuAdmin menuAdmin = new MenuAdmin();
    private String email;
    private String password;

    private User user = null;
    public void startProfile(String email,String password) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (loginService.isLogin(email, password)) {
                user = userService.showUserProfile(email, password);
                System.out.println("Nama User : " + user.getUserName());
                System.out.println("Email     : " + user.getEmail());
                System.out.println("Password  : " + user.getPassword());
                System.out.println();

                System.out.println("1.Ubah password");
                System.out.println("2.Ubah username");
                System.out.println("3.Exit");
                System.out.println("Masukkan pilihan : ");
                int input = scanner.nextInt();
                scanner.nextLine();

                if(input == 1){
                    System.out.println("Masukkan password baru : ");
                    String newPassword = scanner.nextLine();
                    userService.update(newPassword,user.getEmail(),"password");
                    LoginView loginView =  new LoginView();
                    System.out.println("Silahkan login kembali!");
                    loginView.start();
                }
                else if(input == 2){
                    System.out.println("Masukkan username baru : ");
                    String newUsername = scanner.nextLine();
                    userService.update(newUsername,user.getEmail(),"username");

                }
                else if(input == 3)
                    return;

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void startBelanja(String email,String password){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String ran =  "id_" + random.nextInt(0,1000);
        String transaksiRan = "t_" + random.nextInt(0,2000);

        try {

            System.out.println("1.Mobil");
            System.out.println("2.Motor");
            int input = scanner.nextInt();
            scanner.nextLine();

            if(input == 1){
                System.out.println("List Mobil");

                for(var i : mobilService.selectAllJoin()) {
                    System.out.println("=".repeat(30));
                    System.out.println("Nama Mobil      : " + i.getNama_mobil());
                    System.out.println("Nama Perusahaan : " + i.getCompany().getNama());
                    System.out.println("Harga           : " + i.getHarga());
                }

                System.out.print("Masukkan mobil pilihan anda : ");
                String mobil = scanner.nextLine();

                user = userService.showUserProfile(email,password);
                Mobil mobil1 = mobilService.getId(mobil);
                Mobil mobil2 = mobilService.getIdCompany(mobil);

                pembeliService.insert(ran,user.getUserName(),email);

                transaksiService.insert(transaksiRan, ran, mobil2.getCompany_id(), mobil1.getId(),"transaksi_mobil");

            }

            else if(input == 2){

                System.out.println("List Motor");
                for(var i : motorService.selectAllJoin()){

                    System.out.println("=".repeat(30));
                    System.out.println("Nama              : " + i.getNama_motor());
                    System.out.println("Nama Perusaahaan  : " + i.getCompany().getNama());
                    System.out.println("Harga             : " + i.getHarga());

                }

                System.out.print("Masukkan motor pilihan anda : ");
                String motor = scanner.nextLine();

                user = userService.showUserProfile(email,password);
                Motor motor1 = motorService.getId(motor);
                Motor motor2 = motorService.getIdCompany(motor);

                pembeliService.insert(ran,user.getUserName(),email);

                transaksiService.insert(transaksiRan,ran,motor2.getIdCompany(), motor1.getId(),"transaksi_motor");

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void lihatBelanjaan(String email){
        Double sum = 0D;
        try{
            System.out.println("List mobil");
            for(var i : transaksiService.transaksiMobil(email,"mobil")){
                System.out.println("=".repeat(30));
                System.out.println("ID transaksi    : " + i.getId());
                System.out.println("Pesanan         : " + i.getPesanan());
                System.out.println("Harga_pesanan   : " + i.getHarga_pesanan());
                System.out.println("Nama perusahaan : " + i.getNama_perusahaan());
                sum += i.getHarga_pesanan();
            }

            System.out.println();
            System.out.println("List motor");
            for (var i : transaksiService.transaksiMotor(email,"motor")){
                System.out.println("=".repeat(30));
                System.out.println("ID transaksi    : " + i.getId());
                System.out.println("Pesanan         : " + i.getPesanan());
                System.out.println("Harga_pesanan   : " + i.getHargaPesanan());
                System.out.println("Nama Perusahaan : " + i.getNamaPerusahaan());
                sum += i.getHargaPesanan();
            }

            System.out.println();
            System.out.println("Total harga = " + sum);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int pilih = 0;
        do {

            System.out.println("1.Lihat profile");
            System.out.println("2.Belanja");
            System.out.println("3.Lihat Belanjaan");
            System.out.println("4.exit");
            pilih = scanner.nextInt();

            switch (pilih){
                case 1 -> startProfile(getEmail(),getPassword());
                case 2 -> startBelanja(getEmail(),getPassword());
                case 3 -> lihatBelanjaan(getEmail());
                case 4 -> System.out.println("Bye!");
                default -> System.out.println("Inputan tidak valid");
            }

        }while (pilih != 4);
    }
    public void login(){
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan email : ");
            String email = scanner.nextLine();
            this.email = email;

            System.out.print("Masukkan password : ");
            String password = scanner.nextLine();
            this.password = password;

            loginAuthenthication.setRoles(email,password);

            if(loginAuthenthication.getRoles().equals("user"))
                run();

            else if(loginAuthenthication.getRoles().equals("admin"))
                menuAdmin.run();

            else
                System.out.println("Password / email salah");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public String getPassword() {
        return password;
    }
    public String getEmail(){
        return email;
    }
}
