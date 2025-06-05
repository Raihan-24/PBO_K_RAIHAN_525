import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStokSenjata {
    private static ArrayList<Senjata> daftarSenjata = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih opsi: ");
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahSenjata();
                        break;
                    case 2:
                        tampilkanSemuaSenjata();
                        break;
                    case 3:
                        kurangiStokSenjata();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Program manajemen stok senjata berakhir.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka!");
                scanner.nextLine(); // Membersihkan input yang salah
            }
        }
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n===== Sistem Manajemen Stok Senjata =====");
        System.out.println("1. Tambah Senjata Baru");
        System.out.println("2. Tampilkan Semua Senjata");
        System.out.println("3. Kurangi Stok Senjata");
        System.out.println("0. Keluar");
    }

    private static void tambahSenjata() {
        System.out.print("Masukkan jenis senjata: ");
        String jenis = scanner.nextLine();
        System.out.print("Masukkan nomor seri: ");
        String nomorSeri = scanner.nextLine();

        try {
            System.out.print("Masukkan stok awal: ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            Senjata senjataBaru = new Senjata(jenis, nomorSeri, stok);
            daftarSenjata.add(senjataBaru);
            System.out.println("Senjata '" + jenis + "' dengan nomor seri " + nomorSeri + " berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Input stok harus berupa angka!");
            scanner.nextLine(); // Membersihkan input yang salah
        }
    }

    private static void tampilkanSemuaSenjata() {
        if (daftarSenjata.isEmpty()) {
            System.out.println("Gudang senjata kosong.");
            return;
        }

        System.out.println("\n--- Daftar Senjata ---");
        Iterator<Senjata> iterator = daftarSenjata.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Senjata senjata = iterator.next();
            System.out.println(index + ". Jenis: " + senjata.getJenis() +
                    ", Nomor Seri: " + senjata.getNomorSeri() +
                    ", Stok: " + senjata.getStok());
            index++;
        }
    }

    private static void kurangiStokSenjata() {
        if (daftarSenjata.isEmpty()) {
            System.out.println("Tidak ada senjata dalam stok.");
            return;
        }

        tampilkanSemuaSenjata();

        try {
            System.out.print("Masukkan nomor indeks senjata: ");
            int index = scanner.nextInt();

            if (index < 0 || index >= daftarSenjata.size()) {
                System.out.println("Error: Indeks tidak valid!");
                return;
            }

            System.out.print("Masukkan jumlah stok yang akan diambil: ");
            int jumlahDiambil = scanner.nextInt();
            scanner.nextLine();

            Senjata senjata = daftarSenjata.get(index);

            if (jumlahDiambil > senjata.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + senjata.getJenis() +
                       " hanya tersisa " + senjata.getStok());
            }

            senjata.setStok(senjata.getStok() - jumlahDiambil);
            System.out.println("Stok senjata '" + senjata.getJenis() +
                    "' berhasil dikurangi. Sisa stok: " + senjata.getStok());

        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");
            scanner.nextLine(); // Membersihkan input yang salah
        } catch (StokTidakCukupException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}