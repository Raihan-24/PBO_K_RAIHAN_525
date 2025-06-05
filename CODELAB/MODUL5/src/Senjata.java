class Senjata {
    private String jenis;
    private String nomorSeri;
    private int stok;

    public Senjata(String jenis, String nomorSeri, int stok) {
        this.jenis = jenis;
        this.nomorSeri = nomorSeri;
        this.stok = stok;
    }

    public String getJenis() {
        return jenis;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}