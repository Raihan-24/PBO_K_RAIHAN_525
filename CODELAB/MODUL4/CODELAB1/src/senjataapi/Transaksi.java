package senjataapi;

public interface Transaksi {
    void transaksiSenjata(String namaSenjata);
    void transaksiSenjata(String namaSenjata, int jumlah);
    void konfirmasiTransaksi(String namaSenjata);
}

