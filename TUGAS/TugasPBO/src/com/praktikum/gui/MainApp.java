package com.praktikum.gui;

import com.praktikum.gui.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new LoginPane(stage), 400, 300);
        stage.setTitle("Lost & Found System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
