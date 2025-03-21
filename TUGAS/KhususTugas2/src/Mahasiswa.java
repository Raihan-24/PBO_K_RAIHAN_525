// Kelas Mahasiswa
class Mahasiswa {
    private String nama = "Raihan Ghifari Alfatah";
    private String nim = "525";

    public boolean login(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}
