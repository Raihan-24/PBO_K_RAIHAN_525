// Kelas Admin
class Admin {
    private String username = "Admin525";
    private String password = "Password525";

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}
