import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Nama
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine(); // Menggunakan nextLine() untuk mengambil seluruh teks

        // Input Jenis Kelamin
        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        String gender = scanner.next().toUpperCase(); // Mengubah input menjadi huruf besar

        // Menentukan jenis kelamin
        String jenisKelamin;
        if (gender.equals("L")) {
            jenisKelamin = "Laki-laki";
        } else if (gender.equals("P")) {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = "Tidak diketahui"; // Jika input tidak valid
        }

        // Input Tahun Lahir
        System.out.print("Masukkan Tahun Lahir: ");
        int tahunLahir = scanner.nextInt();

        // Hitung Usia
        int tahunSekarang = 2025; // Tahun saat ini (bisa juga menggunakan Calendar.getInstance().get(Calendar.YEAR))
        int usia = tahunSekarang - tahunLahir;

        // Cetak Data Diri
        System.out.println("\n=== Data Diri ===");
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Tahun Lahir  : " + tahunLahir);
        System.out.println("Usia         : " + usia + " tahun");

        scanner.close(); // Menutup scanner untuk menghindari kebocoran sumber daya
    }
}