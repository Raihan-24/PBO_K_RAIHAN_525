// Kelas untuk merepresentasikan rekening bank
class RekeningBank {
    String nomorRekening; // Menyimpan nomor rekening nasabah
    String namaPemilik;   // Menyimpan nama pemilik rekening
    double saldo;         // Menyimpan saldo rekening

    // Method untuk menampilkan informasi rekening
    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    // Method untuk menyetor uang ke rekening
    void setorUang(double jumlah) {
        saldo = saldo + jumlah; // Menambahkan jumlah ke saldo
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    // Method untuk menarik uang dari rekening
    void tarikUang(double jumlah) {
        if (saldo >= jumlah) { // Mengecek apakah saldo mencukupi
            saldo = saldo - jumlah; // Mengurangi saldo
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        }
    }
}


