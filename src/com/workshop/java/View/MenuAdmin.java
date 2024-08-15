package com.workshop.java.View;

import java.sql.SQLException;
import java.util.Scanner;
import com.workshop.java.Controller.CompanyService;
import com.workshop.java.Controller.MobilService;
import com.workshop.java.Controller.MotorService;
import com.workshop.java.Controller.PembeliService;
import com.workshop.java.Model.Company;


public class MenuAdmin {
    final CompanyService companyService = new CompanyService();
    final MotorService motorService = new MotorService();
    final MobilService mobilService = new MobilService();
    final PembeliService pembeliService = new PembeliService();

    public void startInsert(){
        String nama;
        String id;
        Scanner scanner = new Scanner(System.in);
        Company company;
        try{
        System.out.println("1.Insert Company");
        System.out.println("2.Insert Motor");
        System.out.println("3.Insert Mobil");
        System.out.print("Masukkan pilihan : ");

        for (int i = 0; i < 50; i++) System.out.println();

            int input = scanner.nextInt();
        scanner.nextLine();
            switch (input){
                case 1 :
                    System.out.print("Masukkan id : ");
                    id = scanner.nextLine();

                    System.out.print("Masukkan nama : ");
                    nama = scanner.nextLine();
                    companyService.insert(id,nama);
                    break;

                case 2:
                    System.out.print("Masukkan id : ");
                    id = scanner.nextLine();

                    System.out.println("Daftar Company : ");
                    for(var i : companyService.select()){
                        System.out.println(i.getNama());
                    }

                    System.out.print("Masukkan nama Company : ");
                    String company_name = scanner.nextLine();
                    System.out.print("Masukkan nama : ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Harga : ");
                    Double harga = scanner.nextDouble();
                    company = companyService.getId(company_name);
                    motorService.insert(id,company.getId(),nama,harga);
                    break;

                case 3:
                    System.out.print("Masukkan id : ");
                    id = scanner.nextLine();

                    System.out.println("Daftar Company : ");
                    for(var i : companyService.select()){
                        System.out.println(i.getNama());
                    }

                    System.out.print("Masukkan nama Company : ");
                    company_name = scanner.nextLine();
                    System.out.print("Masukkan nama : ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Harga : ");
                    harga = scanner.nextDouble();

                    company = companyService.getId(company_name);
                    motorService.insert(id,company.getId(),nama,harga);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void startUpdate(){
        Scanner scanner = new Scanner(System.in);
        Company company;
        System.out.println("1.Update Company");
        System.out.println("2.Update Motor");
        System.out.println("3.Update Mobil");
        try {

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    int index = 0;
                    System.out.println("List Company");
                    for(var i : companyService.select()){
                        ++index;
                        System.out.println("=".repeat(40));
                        System.out.println(index + ".nama : " + i.getNama());
                        System.out.println("id  : " + i.getId());
                    }

                    System.out.print("Masukkan nama perusahaan yang ingin di update : ");
                    String oldCompany = scanner.nextLine();

                    System.out.print("Masukkan nama Perusahaan yang baru : ");
                    String newCompany = scanner.nextLine();

                    company = companyService.getId(oldCompany);
                    companyService.update(newCompany,company.getId(),"nama");
                    break;

                case 2:
                    index = 0;
                    System.out.println("List Motor");
                    for(var i : motorService.selectAllJoin()){
                        ++index;
                        System.out.println("=".repeat(40));
                        System.out.println(index+".Nama : " + i.getNama_motor());
                        System.out.println("id : " + i.getId());
                        System.out.println("Perusahaan : " + i.getCompany().getNama());
                        System.out.println("Harga : " + i.getHarga());
                    }
                    System.out.println("1.Update  nama");
                    System.out.println("2.Update Harga");
                    System.out.println("3.Update perusahaan");

                    input = scanner.nextInt();
                    scanner.nextLine();
                    if(input == 1){
                        System.out.print("Masukkan nama : ");
                        String newNama = scanner.nextLine();

                        System.out.print("Masukkan id : ");
                        String id = scanner.nextLine();

                        motorService.update(newNama,id,"nama");
                    }
                    else if(input == 2){
                        System.out.print("Masukkan Harga : ");
                        Double newHarga = scanner.nextDouble();

                        System.out.print("Masukkan id : ");
                        String id = scanner.nextLine();

                        motorService.update(newHarga,id,"harga");
                    }
                    else if(input == 3){
                        System.out.print("Masukkan perusahaan : ");
                        String newPerusahaan = scanner.nextLine();

                        System.out.print("Masukkan id : ");
                        String id = scanner.nextLine();

                        company = companyService.getId(newPerusahaan);
                        motorService.update(company.getId(),id,"company_id");
                    }
                    else{
                        System.out.println("Tidak ada pilihan yang cocok");
                    }
                    break;

                case 3:
                    index = 0;
                    System.out.println("List Mobil");
                    for(var i : mobilService.selectAllJoin()){
                        System.out.println(index+".Nama : " + i.getNama_mobil());
                        System.out.println("id : " + i.getId());
                        System.out.println("Perusahaan : " + i.getCompany().getNama());
                        System.out.println("Harga : " + i.getHarga());
                    }

                    System.out.println("1.Update  nama");
                    System.out.println("2.Update Harga");
                    System.out.println("3.Update perusahaan");

                    input = scanner.nextInt();

                    if(input == 1){
                        System.out.print("Masukkan nama : ");
                        String newNama = scanner.nextLine();

                        System.out.print("Masukkan id : ");
                        String id = scanner.nextLine();

                        mobilService.update(newNama,id,"nama");
                    }

                    else if(input == 2){
                        System.out.print("Masukkan Harga : ");
                        Double newHarga = scanner.nextDouble();

                        System.out.print("Masukkan id : ");
                        String id = scanner.nextLine();

                        mobilService.update(newHarga,id,"harga");
                    }

                    else if(input == 3){
                        System.out.print("Masukkan perusahaan : ");
                        String newPerusahaan = scanner.nextLine();

                        System.out.print("Masukkan id : ");
                        String id = scanner.nextLine();

                        company = companyService.getId(newPerusahaan);
                        mobilService.update(company.getId(),id,"company_id");
                    }

                    else{
                        System.out.println("Tidak ada pilihan yang cocok");
                    }
                    break;

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void startDelete(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Delete Company");
        System.out.println("2.Delete Motor");
        System.out.println("3.Delete Mobil");
        int input = scanner.nextInt();
        try{
            switch(input) {
                case 1:
                    System.out.println("List Company : ");
                    for (var i : companyService.select()) {
                        System.out.println("=".repeat(30));
                        System.out.println("id   : " + i.getNama());
                        System.out.println("Nama : " + i.getNama());
                    }
                    System.out.print("Masukan Nama yang ingin dihapus! : ");
                    String nama = scanner.nextLine();
                    Company company = companyService.getId(nama);
                    companyService.delete(company.getId());
                    break;

                case 2:
                    System.out.println("List Motor : ");
                    for(var i : motorService.selectAllJoin()){
                        System.out.println("=".repeat(30));
                        System.out.println("ID         : " + i.getId());
                        System.out.println("Nama       : " + i.getNama_motor());
                        System.out.println("Perusahaan : " + i.getCompany().getNama());
                        System.out.println("Harga      : " + i.getHarga());
                    }
                    System.out.print("Masukkan ID yang ingin di hapus : ");
                    String id = scanner.nextLine();
                    motorService.delete(id);
                    break;

                case 3:
                    System.out.println("List Mobil : ");
                    for(var i : mobilService.selectAllJoin()){
                        System.out.println("=".repeat(30));
                        System.out.println("ID          : " + i.getId());
                        System.out.println("Nama        : " + i.getNama_mobil());
                        System.out.println("Perusahaan  : " + i.getCompany().getNama());
                        System.out.println("Harga       : " + i.getHarga());
                    }
                    System.out.print("Masukkan ID yang ingin di hapus : ");
                    id = scanner.nextLine();
                    mobilService.delete(id);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void startView(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Tampilkan Data Company");
        System.out.println("2.Tampilkan Data Motor");
        System.out.println("3.Tampilkan Data Mobil");
        System.out.println("4.Tampilkan Data Pembeli");
        try {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    int index = 0;
                    System.out.println("List Company");
                    for (var i : companyService.select()) {
                        ++index;
                        System.out.println("=".repeat(40));
                        System.out.println(index + ".nama : " + i.getNama());
                        System.out.println("id  : " + i.getId());
                    }
                    break;

                case 2:
                    index = 0;
                    System.out.println("List Motor");
                    for(var i : motorService.selectAllJoin()){
                        ++index;
                        System.out.println("=".repeat(40));
                        System.out.println(index+".Nama : " + i.getNama_motor());
                        System.out.println("id : " + i.getId());
                        System.out.println("Perusahaan : " + i.getCompany().getNama());
                        System.out.println("Harga : " + i.getHarga());
                    }
                    break;
                case 3:
                    index = 0;
                    System.out.println("List Mobil");
                    for(var i : mobilService.selectAllJoin()){
                        System.out.println(index+".Nama : " + i.getNama_mobil());
                        System.out.println("id : " + i.getId());
                        System.out.println("Perusahaan : " + i.getCompany().getNama());
                        System.out.println("Harga : " + i.getHarga());
                    }
                    break;
                case 4:
                    index = 0;
                    System.out.println("List pembeli");
                    for(var i :pembeliService.selectAll()){
                        System.out.println(index+".Nama : " + i.getNama());
                        System.out.println("id : " + i.getId());
                        System.out.println("no_hp : " + i.getNo_hp());
                    }
                    break;

                default:
                    System.out.println("pilihan tidak valid");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void run(){
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=".repeat(30) + " -ADMIN MODE- " + "=".repeat(30));
            System.out.println("1.Insert data");
            System.out.println("2.Delete data");
            System.out.println("3.Update data");
            System.out.println("4.Lihat data");
            System.out.println("5.Exit");

            int input = scanner.nextInt();
            switch (input){
                case 1 -> startInsert();
                case 2 -> startDelete();
                case 3 -> startUpdate();
                case 4 -> startView();
                case 5 -> flag = false;
                default -> System.out.println("Invalid input");
            }
        }while(flag);
    }
}
