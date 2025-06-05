package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.data.DataStore;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard extends VBox {
    public AdminDashboard(Admin admin, Stage stage) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label welcome = new Label("Halo, " + admin.getNama());

        // === TABEL BARANG ===
        TableView<Item> itemTable = new TableView<>(DataStore.getItems());

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(cell -> cell.getValue().nameProperty());

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(cell -> cell.getValue().locationProperty());

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(cell -> cell.getValue().statusProperty());

        itemTable.getColumns().addAll(namaCol, lokasiCol, statusCol);
        itemTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button claimedBtn = new Button("Tandai Claimed");
        claimedBtn.setOnAction(e -> {
            Item selected = itemTable.getSelectionModel().getSelectedItem();
            if (selected != null && !selected.getStatus().equals("Claimed")) {
                selected.setStatus("Claimed");
                itemTable.refresh();
            }
        });

        VBox barangBox = new VBox(10, new Label("Laporan Barang"), itemTable, claimedBtn);
        barangBox.setPrefWidth(400);

        // === TABEL MAHASISWA ===
        TableView<Mahasiswa> mhsTable = new TableView<>(DataStore.getMahasiswaList());

        TableColumn<Mahasiswa, String> namaMhsCol = new TableColumn<>("Nama");
        namaMhsCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getNama()));

        TableColumn<Mahasiswa, String> nimMhsCol = new TableColumn<>("NIM");
        nimMhsCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getNim()));

        mhsTable.getColumns().addAll(namaMhsCol, nimMhsCol);
        mhsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TextField namaField = new TextField();
        namaField.setPromptText("Nama");

        TextField nimField = new TextField();
        nimField.setPromptText("NIM");

        Button addBtn = new Button("Tambah");
        addBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String nim = nimField.getText();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                Mahasiswa m = new Mahasiswa(nama, nim);
                if (!DataStore.getMahasiswaList().contains(m)) {
                    DataStore.addMahasiswa(m);
                    mhsTable.refresh();
                    namaField.clear();
                    nimField.clear();
                }
            }
        });

        Button deleteBtn = new Button("Hapus");
        deleteBtn.setOnAction(e -> {
            Mahasiswa selected = mhsTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                DataStore.removeMahasiswa(selected);
                mhsTable.refresh();
            }
        });

        VBox formBox = new VBox(5, new HBox(10, namaField, nimField, addBtn), deleteBtn);
        VBox mahasiswaBox = new VBox(10, new Label("Data Mahasiswa"), mhsTable, formBox);
        mahasiswaBox.setPrefWidth(400);

        // === TATA LETAK HORIZONTAL ===
        HBox dashboardContent = new HBox(20, barangBox, mahasiswaBox);

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> stage.setScene(new Scene(new LoginPane(stage), 400, 300)));

        getChildren().addAll(welcome, dashboardContent, logoutBtn);
    }
}
