package senjataapi;

public class SenjataRingan extends Senjata {
    public SenjataRingan(String nama, String pabrikan) {
        super(nama, pabrikan);
    }

    @Override
    public void displayInfo() {
        System.out.println("Senjata Ringan: " + nama + " oleh " + pabrikan);
    }
}

