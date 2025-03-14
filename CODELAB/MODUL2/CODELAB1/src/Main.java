public class Main {
    public static void main(String[] args) {
        // Membuat objek Hewan tanpa menggunakan konstruktor
        manusia orang1 = new manusia();
        orang1.nama = "Raihan";
        orang1.hobby = "Badminton";
        orang1.makananfavorit = "Geprek";
        orang1.tampilkanInfo();

        manusia orang2 = new manusia();
        orang2.nama = "Bayu";
        orang2.hobby = "Gym";
        orang2.makananfavorit = "Sushi";
        orang2.tampilkanInfo();
    }
}