import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

public class TebakNamaBuah extends Application {
    private final String[] daftarKata = {
            "apel", "mangga", "jeruk", "pisang", "anggur",
            "nanas", "pepaya", "melon", "durian", "semangka",
            "lemon", "kiwi", "salak", "rambutan", "jambu",
            "manggis", "alpukat", "sirsak", "belimbing", "duku",
            "ceri", "markisa", "kurma", "kelapa", "delima",
            "kedondong", "cempedak", "lengkeng", "sawo", "buah naga"
    };
    private String kataAcak;
    private StringBuilder kataTebakan;
    private int kesempatan;
    private int jumlahPercobaan;
    private TextField inputField;
    private Button actionButton;
    private Label feedbackLabel;
    private Label percobaanLabel;
    private Label instruksiLabel;
    private Label kataLabel;
    private Label clueLabel;

    private void generateKataBaru() {
        Random rand = new Random();
        kataAcak = daftarKata[rand.nextInt(daftarKata.length)];
        kataTebakan = new StringBuilder();
        kataTebakan.append("_".repeat(kataAcak.length()));
        kesempatan = 5;
        jumlahPercobaan = 0;
        clueLabel.setText("Clue: -");
    }

    @Override
    public void start(Stage primaryStage) {
        // Judul
        Label judulLabel = new Label("🔤 Tebak Nama Buah");
        judulLabel.setFont(Font.font("Arial", 24));
        judulLabel.setTextFill(Color.web("#225ed8"));

        // Instruksi awal
        instruksiLabel = new Label("Tebak huruf atau kata! (5 kesempatan salah)");
        instruksiLabel.setFont(Font.font("Arial", 14));
        instruksiLabel.setTextFill(Color.web("#225ed8"));

        // Label kata (dengan underscore)
        kataLabel = new Label("");
        kataLabel.setFont(Font.font("Arial", 20));

        // Clue Label
        clueLabel = new Label("Clue: -");
        clueLabel.setFont(Font.font("Arial", 16));
        clueLabel.setTextFill(Color.web("#888"));

        // Feedback
        feedbackLabel = new Label("");
        feedbackLabel.setFont(Font.font("Arial", 18));
        feedbackLabel.setAlignment(Pos.CENTER);

        // Input field
        inputField = new TextField();
        inputField.setPromptText("Masukkan huruf/kata di sini");
        inputField.setPrefWidth(180);

        // Tombol aksi
        actionButton = new Button("Coba Tebak!");
        actionButton.setFont(Font.font("Arial", 14));
        actionButton.setStyle("-fx-background-color: #2ecc40; -fx-text-fill: white;");

        // Label jumlah percobaan
        percobaanLabel = new Label("Jumlah percobaan: 0 | Kesempatan: 5");
        percobaanLabel.setFont(Font.font("Arial", 13));
        percobaanLabel.setTextFill(Color.web("#888"));

        // HBox untuk input dan tombol
        HBox inputBox = new HBox(10, inputField, actionButton);
        inputBox.setAlignment(Pos.CENTER);

        // VBox utama
        VBox root = new VBox(15, judulLabel, instruksiLabel, kataLabel, clueLabel, feedbackLabel, inputBox, percobaanLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #eaf3fb;");

        // Generate kata acak pertama
        generateKataBaru();
        updateKataLabel();

        // Event handler tombol
        actionButton.setOnAction(e -> prosesTebakan());
        inputField.setOnAction(e -> prosesTebakan());

        Scene scene = new Scene(root, 420, 350);
        primaryStage.setTitle("Main Tebak Nama Buah Gaes");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void updateKataLabel() {
        StringBuilder tampilan = new StringBuilder();
        for (int i = 0; i < kataTebakan.length(); i++) {
            tampilan.append(kataTebakan.charAt(i)).append(" ");
        }
        kataLabel.setText(tampilan.toString());
    }

    private void prosesTebakan() {
        if (actionButton.getText().equals("Main Lagi")) {
            generateKataBaru();
            updateKataLabel();
            inputField.setDisable(false);
            inputField.clear();
            inputField.setPromptText("Masukkan huruf/kata di sini");
            actionButton.setText("Coba Tebak!");
            actionButton.setStyle("-fx-background-color: #2ecc40; -fx-text-fill: white;");
            feedbackLabel.setText("");
            instruksiLabel.setText("Tebak huruf atau kata! (5 kesempatan salah)");
            percobaanLabel.setText("Jumlah percobaan: 0 | Kesempatan: 5");
            clueLabel.setText("Clue: -");
            return;
        }

        String input = inputField.getText().trim().toLowerCase();
        if (input.isEmpty()) {
            feedbackLabel.setText("⚠ Masukkan huruf/kata terlebih dahulu!");
            feedbackLabel.setTextFill(Color.ORANGE);
            return;
        }

        jumlahPercobaan++;
        boolean benar = false;

        // Jika input adalah satu huruf
        if (input.length() == 1) {
            char huruf = input.charAt(0);
            boolean ada = false;
            for (int i = 0; i < kataAcak.length(); i++) {
                if (kataAcak.charAt(i) == huruf) {
                    kataTebakan.setCharAt(i, huruf);
                    ada = true;
                    benar = true;
                }
            }
            if (!ada) {
                kesempatan--;
                feedbackLabel.setText("✖ Huruf tidak ada! Kesempatan: " + kesempatan);
                feedbackLabel.setTextFill(Color.web("#ff9800"));
                // Tampilkan clue: huruf awal dan akhir
                clueLabel.setText("Clue: Huruf awal: " + kataAcak.charAt(0) + ", Huruf akhir: " + kataAcak.charAt(kataAcak.length()-1));
            } else {
                feedbackLabel.setText("✔ Huruf benar!");
                feedbackLabel.setTextFill(Color.web("#00b050"));
            }
        }
        // Jika input adalah kata lengkap
        else if (input.equals(kataAcak)) {
            kataTebakan = new StringBuilder(kataAcak);
            benar = true;
            feedbackLabel.setText("✔ Tebakan benar!");
            feedbackLabel.setTextFill(Color.web("#00b050"));
        } else {
            kesempatan--;
            feedbackLabel.setText("✖ Kata salah! Kesempatan: " + kesempatan);
            feedbackLabel.setTextFill(Color.web("#ff9800"));
            // Tampilkan clue: huruf awal dan akhir
            clueLabel.setText("Clue: Huruf awal: " + kataAcak.charAt(0) + ", Huruf akhir: " + kataAcak.charAt(kataAcak.length()-1));
        }

        updateKataLabel();
        percobaanLabel.setText("Jumlah percobaan: " + jumlahPercobaan + " | Kesempatan: " + kesempatan);

        // Cek kemenangan atau kekalahan
        if (kataTebakan.toString().equals(kataAcak)) {
            feedbackLabel.setText("✔ Selamat! Kamu menang!");
            feedbackLabel.setTextFill(Color.web("#00b050"));
            inputField.setDisable(true);
            actionButton.setText("Main Lagi");
            actionButton.setStyle("-fx-background-color: #225ed8; -fx-text-fill: white;");
            clueLabel.setText("Clue: -");
        } else if (kesempatan <= 0) {
            feedbackLabel.setText("✖ Game over! Kata: " + kataAcak);
            feedbackLabel.setTextFill(Color.RED);
            kataLabel.setText(kataAcak);
            inputField.setDisable(true);
            actionButton.setText("Main Lagi");
            actionButton.setStyle("-fx-background-color: #225ed8; -fx-text-fill: white;");
            clueLabel.setText("Clue: -");
        }

        inputField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
