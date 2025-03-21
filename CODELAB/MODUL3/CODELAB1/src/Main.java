// Kelas Main
public class Main {
    public static void main(String[] args) {
        // Membuat objek
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        // Menampilkan status awal
        System.out.println("Status awal:");
        System.out.println("Brimstone memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println("Viper memiliki kesehatan: " + viper.getKesehatan());

        // Simulasi pertarungan
        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
