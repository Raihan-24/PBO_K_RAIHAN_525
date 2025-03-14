// Kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat dua objek RekeningBank
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        // Inisialisasi atribut rekening1
        rekening1.nomorRekening = "202410370110525"; // NIM pengguna
        rekening1.namaPemilik = "Raihan Ghifari";         // Nama pengguna
        rekening1.saldo = 500000.0;                 // Saldo awal

        // Inisialisasi atribut rekening2
        rekening2.nomorRekening = "202410370110515"; // NIM teman
        rekening2.namaPemilik = "Bayu Satrio";           // Nama teman
        rekening2.saldo = 1000000.0;                // Saldo awal

        // Menampilkan informasi awal rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Simulasi transaksi setor uang
        rekening1.setorUang(200000.0);  // Maharani menyetor Rp200.000
        rekening2.setorUang(500000.0);  // Amelia menyetor Rp500.000

        // Simulasi transaksi tarik uang
        rekening1.tarikUang(800000.0);  // Maharani mencoba menarik Rp800.000 (gagal)
        rekening2.tarikUang(300000.0);  // Amelia menarik Rp300.000 (berhasil)

        // Menampilkan informasi rekening setelah transaksi
        System.out.println();
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}