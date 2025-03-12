// Kelas LoginSystem (Main)
import java.util.Scanner;

// Kelas Admin
class Admin {
    private String username = "Admin525";
    private String password = "Password525";

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

// Kelas Mahasiswa
class Mahasiswa {
    private String nama = "Raihan Ghifari Alfatah";
    private String nim = "525";

    public boolean login(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

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

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Login Admin ===");
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();

                    if (admin.login(username, password)) {
                        System.out.println("Login Admin berhasil!");
                    } else {
                        System.out.println("Login gagal! Username atau password salah.");
                    }
                    break;

                case 2:
                    // Meminta input nama dan NIM
                    System.out.println("\n=== Login Mahasiswa ===");
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    // Verifikasi dan tampilkan info jika sesuai
                    if (mahasiswa.login(nama, nim)) {
                        System.out.println("Login Mahasiswa berhasil!");
                        mahasiswa.displayInfo(); // Menampilkan informasi mahasiswa
                    } else {
                        // Pesan error jika tidak sesuai
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    running = false;
                    break;

                default:
                    // Pesan error untuk pilihan tidak valid
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}