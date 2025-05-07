package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.println("3. Keluar");
        System.out.print("Masukkan pilihan (1-3): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        User user = null; // Variabel polimorfik

        switch (pilihan) {
            case 1 -> {
                System.out.println("\n=== Login Admin ===");
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                Admin admin = new Admin();
                if (admin.login(username, password)) {
                    System.out.println("Login Admin berhasil!");
                    admin.displayInfo();
                    user = admin;
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
            }
            case 2 -> {
                System.out.println("\n=== Login Mahasiswa ===");
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                Mahasiswa mahasiswa = new Mahasiswa();
                if (mahasiswa.login(nama, nim)) {
                    System.out.println("Login Mahasiswa berhasil!");
                    mahasiswa.displayInfo();
                    user = mahasiswa;
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
            }
            case 3 -> {
                System.out.println("Terima kasih telah menggunakan sistem!");
                // Tidak perlu lanjut
            }
            default -> System.out.println("Pilihan tidak valid!");
        }

        // Panggil menu peran jika login berhasil
        if (user != null) {
            user.displayAppMenu();
        }

        scanner.close();
    }
}
