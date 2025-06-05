package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.users.Mahasiswa;
import com.praktikum.data.DataStore;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MahasiswaDashboard extends VBox {
    public MahasiswaDashboard(Mahasiswa mahasiswa, Stage stage) {
        setPadding(new Insets(20));
        setSpacing(10);

        Label welcome = new Label("Selamat Datang, " + mahasiswa.getNama());
        Label instruksi1 = new Label("Silahkan Laporkan Barang Hilang/Temuan.");
        Label instruksi2 = new Label("Isi Form di Bawah ini:");

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Barang");

        TextField deskripsiField = new TextField();
        deskripsiField.setPromptText("Deskripsi");

        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi");

        Button laporBtn = new Button("Laporkan");

        TableView<Item> table = new TableView<>();
        table.setItems(DataStore.getItems());

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(cell -> cell.getValue().nameProperty());

        TableColumn<Item, String> deskripsiCol = new TableColumn<>("Deskripsi");
        deskripsiCol.setCellValueFactory(cell -> cell.getValue().descriptionProperty());

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(cell -> cell.getValue().locationProperty());

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(cell -> cell.getValue().statusProperty());

        table.getColumns().addAll(namaCol, deskripsiCol, lokasiCol, statusCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        laporBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String deskripsi = deskripsiField.getText();
            String lokasi = lokasiField.getText();
            if (!nama.isEmpty() && !deskripsi.isEmpty() && !lokasi.isEmpty()) {
                DataStore.addItem(new Item(nama, deskripsi, lokasi));
                namaField.clear();
                deskripsiField.clear();
                lokasiField.clear();
            }
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> stage.setScene(new Scene(new LoginPane(stage), 400, 300)));

        getChildren().addAll(welcome, instruksi1, instruksi2,
                new HBox(10, namaField, deskripsiField, lokasiField, laporBtn),
                new Label("Daftar Laporan Barang:"), table, logoutBtn);
    }
}
