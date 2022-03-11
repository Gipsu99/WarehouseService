public class Samochod extends Przedmiot {
    private String nazwa;
    private int powierzchnia;
    private String cecha;


    public Samochod(String nazwa, int powierzchnia, String cecha) {
        super(nazwa, powierzchnia);
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
        this.cecha = cecha;
    }
    public Samochod(String nazwa, String cecha) {
        super(nazwa);
        this.nazwa = nazwa;
        this.cecha = cecha;
    }

    @Override
    public String toString() {
        return  "nazwa: " + nazwa + ", powierzchnia: " + getPowierzchnia() + ", cecha: " + cecha;
    }
}
