// Kelas Main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan (1-3): ");

            int pilihan;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // Membersihkan buffer
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Login Admin ===");
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();

                    if (admin.login(username, password)) {
                        System.out.println("Login Admin berhasil!");
                        admin.displayInfo();
                    } else {
                        System.out.println("Login gagal! Username atau password salah.");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Login Mahasiswa ===");
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    if (mahasiswa.login(nama, nim)) {
                        System.out.println("Login Mahasiswa berhasil!");
                        mahasiswa.displayInfo();
                    } else {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}