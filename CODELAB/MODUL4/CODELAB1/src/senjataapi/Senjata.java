package senjataapi;

public abstract class Senjata {
    protected String nama;
    protected String pabrikan;

    public Senjata(String nama, String pabrikan) {
        this.nama = nama;
        this.pabrikan = pabrikan;
    }

    public abstract void displayInfo();
}
