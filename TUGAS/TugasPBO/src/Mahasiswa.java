// Kelas Mahasiswa (Subclass dari User)
class Mahasiswa extends User {
    // Constructor Mahasiswa menggunakan super untuk inisialisasi nama dan nim
    public Mahasiswa() {
        super("Raihan Ghifari Alfatah", "525");
    }

    // Override method login() untuk mencocokkan nama dan nim
    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    // Override method displayInfo() untuk menampilkan informasi mahasiswa
    @Override
    public void displayInfo() {
        System.out.println("Informasi Mahasiswa:");
        super.displayInfo();
    }
}