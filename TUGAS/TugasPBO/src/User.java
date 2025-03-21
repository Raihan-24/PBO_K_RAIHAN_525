// Kelas Superclass User
class User {
    private String nama;
    private String nim;

    // Constructor untuk menginisialisasi nama dan nim
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk nim
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Method login() yang akan di-override oleh subclass
    // Menggunakan parameter generik untuk mendukung kedua jenis login
    public boolean login(String param1, String param2) {
        return false; // Default implementation, akan di-override
    }

    // Method displayInfo() untuk menampilkan informasi pengguna
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}