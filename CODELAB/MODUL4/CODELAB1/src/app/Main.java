package app;

import senjataapi.*;

public class Main {
    public static void main(String[] args) {
        Senjata s1 = new SenjataRingan("Desert Eagle", "Magnum Research Inc.");
        Senjata s2 = new SenjataBerat("RPG-7", "Bazalt");

        s1.displayInfo();
        s2.displayInfo();
        System.out.println();

        Pengguna penjual = new Pengguna("Raihan Ghifari Alfatah", "K525");
        Pengguna pembeli = new Pengguna("M Aditya Erpraja", "K531");

        penjual.tampilkanInfo("Penjual");
        pembeli.tampilkanInfo("Pembeli");
        System.out.println();

        penjual.transaksiSenjata("Desert Eagle");
        pembeli.transaksiSenjata("RPG-7", 2);
        System.out.println();

        penjual.konfirmasiTransaksi("Desert Eagle");
        pembeli.konfirmasiTransaksi("RPG-7");
    }
}

