package senjataapi;

public class SenjataBerat extends Senjata {
    public SenjataBerat(String nama, String pabrikan) {
        super(nama, pabrikan);
    }

    @Override
    public void displayInfo() {
        System.out.println("Senjata Berat: " + nama + " oleh " + pabrikan);
    }
}

