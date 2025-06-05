package com.praktikum.data;

import com.praktikum.users.Mahasiswa;
import com.praktikum.main.LoginSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStore {
    private static final ObservableList<Item> itemList = FXCollections.observableArrayList();

    private static final ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList(
            new Mahasiswa("Aditya", "531") // Mahasiswa default
    );

    static {
        LoginSystem.userList.addAll(mahasiswaList); // Agar bisa login
    }

    public static ObservableList<Item> getItems() {
        return itemList;
    }

    public static void addItem(Item item) {
        itemList.add(item);
    }

    public static ObservableList<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public static void addMahasiswa(Mahasiswa m) {
        mahasiswaList.add(m);
        LoginSystem.userList.add(m);
    }

    public static void removeMahasiswa(Mahasiswa m) {
        mahasiswaList.remove(m);
        LoginSystem.userList.remove(m);
    }
}
