public class Rower extends Przedmiot {
    private String nazwa;
    private int powierzchnia;
    private int liczbaPrzerzutek;


    public Rower(String nazwa, int powierzchnia, int liczbaPrzerzutek) {
        super(nazwa, powierzchnia);
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
        this.liczbaPrzerzutek = liczbaPrzerzutek;
    }
    public Rower(String nazwa, int liczbaPrzerzutek) {
        super(nazwa);
        this.nazwa = nazwa;
        this.liczbaPrzerzutek = liczbaPrzerzutek;
    }
    public String toString() {
        return  "nazwa: " + nazwa + ", powierzchnia: " + getPowierzchnia() + ", liczba przerzutek: " + liczbaPrzerzutek;
    }
}
