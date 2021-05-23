public class Towar {

    private String nazwaTowaru;
    private int liczbaSztuk;
    private double cena;

    public Towar(){
    }

    public Towar(String nazwaTowaru, int liczbaSztuk, double cena){
        this.nazwaTowaru = nazwaTowaru;
        this.liczbaSztuk = liczbaSztuk;
        this.cena = cena;
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public int getLiczbaSztuk() {
        return this.liczbaSztuk;
    }

    public void setLiczbaSztuk(int liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk;
    }

    public double getCena() {
        return cena;
    }

    public double setCena(double cena) {
        return this.cena = cena;
    }
}
