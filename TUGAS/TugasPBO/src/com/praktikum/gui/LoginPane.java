package com.praktikum.gui;

import com.praktikum.main.LoginSystem;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class LoginPane extends VBox {
    public LoginPane(Stage stage) {
        // Atur layout utama ke tengah
        setAlignment(Pos.CENTER);
        setSpacing(15);
        setPadding(new Insets(20));

        ToggleGroup group = new ToggleGroup();

        // 1. Label "Login sebagai" (tengah)
        Label roleLabel = new Label("Login sebagai:");
        roleLabel.setAlignment(Pos.CENTER);

        // 2. ComboBox role (tengah)
        ComboBox<String> roleCombo = new ComboBox<>();
        roleCombo.getItems().addAll("Admin", "Mahasiswa");
        roleCombo.setValue("Mahasiswa");
        roleCombo.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(roleCombo, Priority.ALWAYS);

        // Field input (tengah)
        TextField namaField = new TextField();
        namaField.setPromptText("Nama");
        namaField.setAlignment(Pos.CENTER);

        PasswordField nimField = new PasswordField();
        nimField.setPromptText("NIM / Password");
        nimField.setAlignment(Pos.CENTER);

        // 3. Tombol Login (tengah)
        Button loginButton = new Button("Login");
        loginButton.setMaxWidth(Double.MAX_VALUE);

        Button ExitButton = new Button("Exit");
        ExitButton.setMaxWidth(Double.MAX_VALUE);
        ExitButton.setOnAction( (ActionEvent e) -> {
            System.exit(0);
        } );

        HBox inputBox = new HBox(5, loginButton,ExitButton);

        // Label status (tengah)
        Label statusLabel = new Label();
        statusLabel.setAlignment(Pos.CENTER);

        // Container untuk komponen form
        VBox formBox = new VBox(10);
        formBox.setAlignment(Pos.CENTER);
        formBox.setMaxWidth(300);
        formBox.getChildren().addAll(
                roleLabel,
                roleCombo,
                namaField,
                nimField,
                loginButton,
                ExitButton,
                statusLabel
        );

        // Tambahkan formBox ke layout utama
        getChildren().add(formBox);

        // Logika login
        LoginSystem.userList.add(new Mahasiswa("Aditya", "531"));

        loginButton.setOnAction(e -> {
            String nama = namaField.getText();
            String nimOrPassword = nimField.getText();
            String role = roleCombo.getValue();

            if (role.equals("Mahasiswa")) {
                for (var user : LoginSystem.userList) {
                    if (user instanceof Mahasiswa m && m.login(nama, nimOrPassword)) {
                        MahasiswaDashboard dashboard = new MahasiswaDashboard(m, stage);
                        Scene scene = new Scene(dashboard, 600, 400);
                        stage.setScene(scene);
                        return;
                    }
                }
                statusLabel.setText("Login mahasiswa gagal.");
            } else {
                Admin admin = new Admin() {
                    @Override
                    public void reportItem() {}
                };
                if (admin.login(nama, nimOrPassword)) {
                    AdminDashboard dashboard = new AdminDashboard(admin, stage);
                    Scene scene = new Scene(dashboard, 700, 500);
                    stage.setScene(scene);
                } else {
                    statusLabel.setText("Login admin gagal.");
                }
            }
        });
    }
}