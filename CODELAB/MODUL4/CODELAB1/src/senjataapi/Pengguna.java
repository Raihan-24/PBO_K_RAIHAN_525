package senjataapi;

public class Pengguna implements Transaksi {
    private String nama;
    private String idPengguna;

    public Pengguna(String nama, String idPengguna) {
        this.nama = nama;
        this.idPengguna = idPengguna;
    }

    public void tampilkanInfo(String peran) {
        System.out.println(peran + ": " + nama + " (ID: " + idPengguna + ")");
    }

    @Override
    public void transaksiSenjata(String namaSenjata) {
        System.out.println(nama + " melakukan transaksi senjata: " + namaSenjata);
    }

    // Overloading
    public void transaksiSenjata(String namaSenjata, int jumlah) {
        System.out.println(nama + " melakukan transaksi senjata \"" + namaSenjata + "\" sebanyak " + jumlah + " unit.");
    }

    @Override
    public void konfirmasiTransaksi(String namaSenjata) {
        System.out.println(nama + " mengkonfirmasi transaksi senjata: " + namaSenjata);
    }
}

