// Kelas Admin (Subclass dari User)
class Admin extends User {
    private String username;
    private String password;

    // Constructor Admin menggunakan super untuk inisialisasi nama dan nim
    public Admin() {
        super("Raihan Ghifari Alfatah", "202410370110525"); // Inisialisasi nama dan nim untuk Admin
        this.username = "Admin525";
        this.password = "Password525";
    }

    // Override method login() untuk memeriksa username dan password
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    // Override method displayInfo() untuk menampilkan informasi Admin
    @Override
    public void displayInfo() {
        System.out.println("Informasi Admin:");
        super.displayInfo();
    }
}